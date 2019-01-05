package com.zlrx.am.writerservice.repository;

import com.zlrx.am.writerservice.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;

@Repository
public class BookRedisRepositoryImpl implements BookRedisRepository {

    private static final String HASH_NAME = "Book";

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    private HashOperations<String, Long, Book> hashOperations;

    @PostConstruct
    private void init() {
        hashOperations = redisTemplate.opsForHash();
    }

    @Override
    public void save(Book book) {
        hashOperations.put(HASH_NAME, book.getAuthorId(), book);
    }

    @Override
    public void delete(Long authorId) {
        hashOperations.delete(HASH_NAME, authorId);
    }

    @Override
    public Book findFirst(Long authorId) {
        return hashOperations.get(HASH_NAME, authorId);
    }
}
