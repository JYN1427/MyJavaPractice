package com.example.springdemo.allAnnotation.autowiredAnno.circulation.set;

import com.example.springdemo.allAnnotation.autowiredAnno.circulation.ServiceB;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author: Jia Yuning
 * @Description:
 * @Date: 2023/12/14 21:20:32
 * @Version: 1.0.0
 */
@Getter
@Component
public class CirculationSetTestServiceB {
    private CirculationSetTestServiceA circulationSetTestServiceA;

    @Autowired
    public void setCirculationSetTestServiceA(CirculationSetTestServiceA circulationSetTestServiceA) {
        this.circulationSetTestServiceA = circulationSetTestServiceA;
    }
}
