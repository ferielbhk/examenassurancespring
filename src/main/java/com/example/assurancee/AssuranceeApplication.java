package com.example.assurancee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class AssuranceeApplication {

    public static void main(String[] args) {
        SpringApplication.run(AssuranceeApplication.class, args);
    }

}
