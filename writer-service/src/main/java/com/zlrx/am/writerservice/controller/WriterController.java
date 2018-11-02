package com.zlrx.am.writerservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RequestMapping("/v1/writer")
@RestController
public class WriterController {

    @GetMapping(path = "/")
    public List<String> getWriters() {
        return Arrays.asList("R.A Salvatore", "J.R.R Tolkien");
    }

}
