package com.example.activate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;


@SpringBootApplication
public class ActivateApplication {
    public static void main(String[] args) {
        SpringApplication.run(ActivateApplication.class, args);
    }
}
