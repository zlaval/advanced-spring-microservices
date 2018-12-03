package com.zlrx.am.bookservice.controller;


import com.zlrx.am.bookservice.domain.Book;
import com.zlrx.am.bookservice.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public Iterable<Book> getBooks() {
        return bookService.findAll();

    }

}
