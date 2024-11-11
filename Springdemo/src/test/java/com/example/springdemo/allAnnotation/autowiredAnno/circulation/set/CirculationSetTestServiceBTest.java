package com.example.springdemo.allAnnotation.autowiredAnno.circulation.set;

import com.example.springdemo.allAnnotation.autowiredAnno.inject.InjectTestBean;
import com.example.springdemo.allAnnotation.autowiredAnno.inject.InjectTestServiceA;
import com.example.springdemo.allAnnotation.autowiredAnno.inject.InjectTestServiceB;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author: Jia Yuning
 * @Description:
 * @Date: 2024/06/19 23:04:54
 * @Version: 1.0.0
 */
@SpringBootTest
class CirculationSetTestServiceBTest {
    @Autowired
    private CirculationSetTestServiceA circulationSetTestServiceA;

    @Autowired
    private CirculationSetTestServiceB circulationSetTestServiceB;

    @Test
    public void test() {
        System.out.println(circulationSetTestServiceA.getClass());
        System.out.println(circulationSetTestServiceB.getClass());

        System.out.println(circulationSetTestServiceA.getCirculationSetTestServiceB().getClass()); // lazy的
        System.out.println(circulationSetTestServiceB.getCirculationSetTestServiceA().getClass());
    }
}