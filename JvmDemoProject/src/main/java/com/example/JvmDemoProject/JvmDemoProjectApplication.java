package com.example.JvmDemoProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.example"})
public class JvmDemoProjectApplication {
    public static void main(String[] args) {
        SpringApplication.run(JvmDemoProjectApplication.class, args);
    }

}
