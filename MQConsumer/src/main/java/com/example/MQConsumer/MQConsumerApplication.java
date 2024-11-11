package com.example.MQConsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.example"})
public class MQConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(MQConsumerApplication.class, args);
    }

}
