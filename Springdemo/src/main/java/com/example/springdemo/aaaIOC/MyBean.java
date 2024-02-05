package com.example.springdemo.aaaIOC;

import org.springframework.stereotype.Component;

/**
 * @Author: Jia Yuning
 * @Description:
 * @Date: 2023/12/28 15:31:32
 * @Version: 1.0.0
 */
@Component
public class MyBean {

    private String message = "jyn nb";

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void printMessage() {
        System.out.println("The message is: " + message);
    }
}