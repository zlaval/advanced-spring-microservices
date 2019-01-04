package com.zlrx.am.writerservice.feign;

import com.zlrx.am.writerservice.model.Book;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.ws.rs.core.MediaType;
import java.util.List;

@FeignClient("book-service")
public interface BookFeignClient {

    @RequestMapping(
            method = RequestMethod.GET,
            value = "/api/v1/book",
            consumes = MediaType.APPLICATION_JSON)
    List<Book> getBooks();

    @RequestMapping(
            method = RequestMethod.GET,
            value = "/api/v1/book/{authorId}",
            consumes = MediaType.APPLICATION_JSON)
    Book getBook(@PathVariable("authorId") Long authorId);

}
