package com.example.SpringDemosProject.allAnnotation.autowiredAnno.circulation.set;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * @Author: Jia Yuning
 * @Description:
 * @Date: 2023/12/14 21:20:32
 * @Version: 1.0.0
 */
@Getter
@Component
public class CirculationSetTestServiceA {
    private CirculationSetTestServiceB circulationSetTestServiceB;

    @Autowired
    public void setCirculationSetTestServiceB(@Lazy CirculationSetTestServiceB circulationSetTestServiceB) {
        this.circulationSetTestServiceB = circulationSetTestServiceB;
    }
}
