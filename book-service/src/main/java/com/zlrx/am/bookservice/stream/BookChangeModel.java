package com.zlrx.am.bookservice.stream;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class BookChangeModel {
    private String action;
    private Long bookId;
    private Long authorId;
}
