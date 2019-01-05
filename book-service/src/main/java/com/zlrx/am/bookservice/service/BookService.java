package com.zlrx.am.bookservice.service;

import com.zlrx.am.bookservice.domain.Book;
import com.zlrx.am.bookservice.repository.BookRepository;
import com.zlrx.am.bookservice.stream.SimpleSourceBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private SimpleSourceBean simpleSourceBean;

    public Iterable<Book> findAll() {
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        return bookRepository.findAll();
    }

    public Book findFirstByAuthorId(Long authorId) {
        return bookRepository.findFirstByAuthorId(authorId);
    }

    public void removeBook(Long bookId) {
        Optional<Book> book = bookRepository.findById(bookId);
        book.ifPresent(b -> {
            bookRepository.delete(b);
            simpleSourceBean.publishBookChange("DELETE", b.getId(), b.getAuthorId());
        });
    }

}
