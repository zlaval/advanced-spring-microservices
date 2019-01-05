package com.zlrx.am.writerservice.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.zlrx.am.writerservice.domain.Writer;
import com.zlrx.am.writerservice.feign.BookFeignClient;
import com.zlrx.am.writerservice.model.AuthorBooks;
import com.zlrx.am.writerservice.model.Book;
import com.zlrx.am.writerservice.repository.BookRedisRepository;
import com.zlrx.am.writerservice.repository.WriterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Transactional
//Class level defaults to Hystrix
//@DefaultProperties(
//        threadPoolKey = "bookServiceThreadPool",
//        threadPoolProperties = {
//                @HystrixProperty(name = "coreSize", value = "20"),
//                @HystrixProperty(name = "maxQueueSize", value = "10")
//        })
public class WriterService {

    @Autowired
    private BookFeignClient bookFeignClient;

    @Autowired
    private WriterRepository writerRepository;

    @Autowired
    private BookRedisRepository bookRedisRepository;

    public Book getAuthorFirstBook(Long authorId) {
        Book cachedBook = bookRedisRepository.findFirst(authorId);
        if (Objects.nonNull(cachedBook)) {
            return cachedBook;
        } else {
            Book book = bookFeignClient.getBook(authorId);
            bookRedisRepository.save(book);
            return book;
        }
    }

    @HystrixCommand(
            fallbackMethod = "fallbackWriters",
            threadPoolKey = "bookServiceThreadPool",
            threadPoolProperties = {
                    @HystrixProperty(name = "coreSize", value = "20"),
                    @HystrixProperty(name = "maxQueueSize", value = "10")
            },
            commandProperties = {
                    @HystrixProperty(
                            name = "circuitBreaker.requestVolumeThreshold", //number of request in 10 sec window before hystrix will consider tripping the circuit breaker
                            value = "10"),
                    @HystrixProperty(
                            name = "circuitBreaker.errorThresholdPercentage", //the percentage of calls must be failed after requestVolumeThreshold has been passed
                            value = "75"),
                    @HystrixProperty(
                            name = "circuitBreaker.sleepWindowInMilliseconds", //after circuit breaker tripped, wait sleepWindowInMilliseconds time while allow the next call through to check health
                            value = "7000"),
                    @HystrixProperty(
                            name = "metrics.rollingStats.timeInMilliseconds", // the size of the window mentioned at requestVolumeThreshold (default: 10 sec)
                            value = "15000"),
                    @HystrixProperty(
                            name = "metrics.rollingStats.numBuckets", // number of times statistics are collected in a window (15 sec window, 5 stat = a stat every 3 second)
                            value = "5")}
//            commandProperties = {
//                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "4000")
//            }
    )
    public Iterable<AuthorBooks> fetchWriters() {
        List<Book> books = bookFeignClient.getBooks();
        Iterable<Writer> writers = writerRepository.findAll();
        Map<Long, List<Book>> autorGrouppedBooks = books.stream()
                .collect(Collectors.groupingBy(Book::getAuthorId, Collectors.toList()));
        return StreamSupport.stream(writers.spliterator(), false)
                .map(writer -> new AuthorBooks(writer.getName(),
                        mapTitle(autorGrouppedBooks, writer)))
                .collect(Collectors.toList());
    }

    private Iterable<AuthorBooks> fallbackWriters() {
        List<AuthorBooks> authorBooks = new ArrayList<>();
        AuthorBooks authorBook = new AuthorBooks();
        authorBook.setName("Zalan Toth");
        List<String> books = new ArrayList<>();
        books.add("No books");
        authorBook.setBooks(books);
        authorBooks.add(authorBook);
        return authorBooks;
    }

    private List<String> mapTitle(Map<Long, List<Book>> autorGrouppedBooks, Writer writer) {
        return autorGrouppedBooks.get(writer.getId()).stream()
                .map(Book::getTitle).collect(Collectors.toList());
    }

}
