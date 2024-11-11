package com.example.springdemo;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

//@SpringBootTest
public class SpringdemoApplicationTests {

    @Test
    public void contextLoads() {
        String s = System.getProperty("java.class.path");
        System.out.println("java.class.path: " + s);
    }

}
