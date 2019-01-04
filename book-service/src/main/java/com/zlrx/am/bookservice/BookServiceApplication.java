package com.zlrx.am.bookservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;

@SpringBootApplication
@EnableEurekaClient
@EnableBinding(Source.class)
public class BookServiceApplication {

    public static void main(String... args) {
        SpringApplication.run(BookServiceApplication.class, args);
    }

}
