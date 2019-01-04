package com.zlrx.am.writerservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@EnableCircuitBreaker
@EnableFeignClients
@SpringBootApplication
@EnableEurekaClient
@EnableResourceServer
//@EnableBinding(Source.class)
public class WriterServiceApplication {

    public static void main(String... args) {
        SpringApplication.run(WriterServiceApplication.class, args);
    }

}
