package com.zlrx.am.bookservice.service;

import com.zlrx.am.bookservice.domain.Book;
import com.zlrx.am.bookservice.repository.BookRepository;
import com.zlrx.am.bookservice.stream.SimpleSourceBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        bookRepository.deleteById(bookId);
        simpleSourceBean.publishBookChange("DELETE", bookId);
    }


}
