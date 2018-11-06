package com.zlrx.am.writerservice.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table
@Getter
@Setter
public class Writer implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @Basic
    private String name;

}
