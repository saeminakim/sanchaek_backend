package com.example.sanchaek_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class SanchaekBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(SanchaekBackendApplication.class, args);
    }

}
