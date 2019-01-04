package com.zlrx.am.bookservice.repository;

import com.zlrx.am.bookservice.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {

    Book findFirstByAuthorId(Long authorId);

}
