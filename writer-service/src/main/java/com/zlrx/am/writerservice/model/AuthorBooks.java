package com.zlrx.am.writerservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AuthorBooks {
    private String name;
    private List<String> books = new ArrayList<>();

    public void addBook(String title) {
        books.add(title);
    }
}
