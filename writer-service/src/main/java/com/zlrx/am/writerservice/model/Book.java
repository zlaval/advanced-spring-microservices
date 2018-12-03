package com.zlrx.am.writerservice.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class Book implements Serializable {
    private Long id;
    private Long authorId;
    private String title;
}
