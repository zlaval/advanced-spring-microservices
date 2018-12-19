package com.zlrx.am.writerservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableCircuitBreaker
@EnableFeignClients
@SpringBootApplication
@EnableEurekaClient
public class WriterServiceApplication {

    public static void main(String... args) {
        SpringApplication.run(WriterServiceApplication.class, args);
    }

}
