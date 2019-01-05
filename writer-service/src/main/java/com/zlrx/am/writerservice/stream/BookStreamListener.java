package com.zlrx.am.writerservice.stream;


import com.zlrx.am.writerservice.repository.BookRedisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BookStreamListener {

    @Autowired
    private BookRedisRepository bookRedisRepository;

    @StreamListener(Sink.INPUT)
    public void removeAuthorBookFromCache(BookChangeModel model) {
        bookRedisRepository.delete(model.getAuthorId());
    }

}
