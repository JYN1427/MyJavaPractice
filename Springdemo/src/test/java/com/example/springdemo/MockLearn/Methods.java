package com.example.springdemo.MockLearn;

import org.springframework.stereotype.Component;

/**
 * @Author: Jia Yuning
 * @Description:
 * @Date: 2023/07/03 12:35:36
 * @Version: 1.0.0
 */
@Component
public class Methods {
    public Integer add(Integer v1, Integer v2) {
        System.out.println("执行add方法");
        return v1 + v2;
    }
}
