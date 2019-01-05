package com.zlrx.am.writerservice.controller;

import com.zlrx.am.writerservice.model.AuthorBooks;
import com.zlrx.am.writerservice.model.Book;
import com.zlrx.am.writerservice.service.WriterService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@Log
@RequestMapping("api/v1/writer")
@RestController
public class WriterController {

    @Autowired
    private WriterService writerService;

    @Autowired
    private HttpServletRequest request;

    @GetMapping
    public Iterable<AuthorBooks> getWriters() {
        String correlationId = request.getHeader("correlation_id");
        log.info(correlationId);
        return writerService.fetchWriters();
    }

    @GetMapping("/{authorId}/firstbook")
    public Book getBook(@PathVariable("authorId") Long authorId) {
        return writerService.getAuthorFirstBook(authorId);
    }

}
