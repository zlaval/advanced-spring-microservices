package com.zlrx.am.writerservice.controller;

import com.zlrx.am.writerservice.model.AuthorBooks;
import com.zlrx.am.writerservice.service.WriterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("api/v1/writer")
@RestController
public class WriterController {

    @Autowired
    private WriterService writerService;

    @GetMapping
    public Iterable<AuthorBooks> getWriters() {
        return writerService.fetchWriters();
    }

}
