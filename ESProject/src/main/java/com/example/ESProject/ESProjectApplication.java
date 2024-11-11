package com.example.ESProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.example"})
public class ESProjectApplication {
    public static void main(String[] args) {
        SpringApplication.run(ESProjectApplication.class, args);
    }

}
