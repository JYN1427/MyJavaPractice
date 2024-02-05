package com.example.springdemo.aop;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author: Jia Yuning
 * @Description: 计算耗时的注解, AOP
 * @Date: 2023/06/27 11:56:31
 * @Version: 1.0.0
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface TimeCost {
    String value() default "";
    int type() default 1;
}
