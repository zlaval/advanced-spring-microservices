package com.zlrx.am.writerservice.service;

import com.zlrx.am.writerservice.domain.Writer;
import com.zlrx.am.writerservice.feign.BookFeignClient;
import com.zlrx.am.writerservice.model.AuthorBooks;
import com.zlrx.am.writerservice.model.Book;
import com.zlrx.am.writerservice.repository.WriterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Transactional
public class WriterService {

    @Autowired
    private BookFeignClient bookFeignClient;

    @Autowired
    private WriterRepository writerRepository;

    public Iterable<AuthorBooks> fetchWriters() {
        List<Book> books = bookFeignClient.getBooks();
        Iterable<Writer> writers = writerRepository.findAll();
        Map<Long, List<Book>> autorGrouppedBooks = books.stream()
                .collect(Collectors.groupingBy(Book::getAuthorId, Collectors.toList()));
        return StreamSupport.stream(writers.spliterator(), false)
                .map(writer -> new AuthorBooks(writer.getName(),
                        mapTitle(autorGrouppedBooks, writer)))
                .collect(Collectors.toList());
    }

    private List<String> mapTitle(Map<Long, List<Book>> autorGrouppedBooks, Writer writer) {
        return autorGrouppedBooks.get(writer.getId()).stream()
                .map(Book::getTitle).collect(Collectors.toList());
    }

}
