package com.zlrx.am.writerservice;

import com.zlrx.am.writerservice.stream.BookChangeModel;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@EnableCircuitBreaker
@EnableFeignClients
@SpringBootApplication
@EnableEurekaClient
@EnableResourceServer
@EnableBinding(Sink.class)
public class WriterServiceApplication {

    public static void main(String... args) {
        SpringApplication.run(WriterServiceApplication.class, args);
    }


    @StreamListener(Sink.INPUT)
    public void logMessage(BookChangeModel model) {
        System.out.println(model.toString());
    }


}
