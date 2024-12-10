package com.example.choreographyservice;

import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ChoreographyServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ChoreographyServiceApplication.class, args);
    }
}