package com.zlrx.am.bookservice.stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
public class SimpleSourceBean {

    @Autowired
    private Source source;

    public void publishBookChange(String action, Long bookId) {
        BookChangeModel bookChangeModel = new BookChangeModel(action, bookId);
        source.output().send(MessageBuilder.withPayload(bookChangeModel).build());
    }


}
