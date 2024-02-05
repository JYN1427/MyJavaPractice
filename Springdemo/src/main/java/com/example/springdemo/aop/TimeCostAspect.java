package com.example.springdemo.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @Author: Jia Yuning
 * @Description: 计算耗时 AOP
 * @Date: 2023/06/27 11:57:07
 * @Version: 1.0.0
 */
@Aspect
@Component
public class TimeCostAspect {

    @Around("within(com.example.springdemo.demos.BaseDemo+)")
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("初始aop...");
        return joinPoint.proceed();
    }

    @Around("@annotation(timeCost)") // 括号里和第二个参数保持一致
    public Object calTaskTime(ProceedingJoinPoint joinPoint, TimeCost timeCost) throws Throwable{
        // Aspect与哪个注解绑定, 取决于第二个参数的类型是哪个注解
        String s = timeCost.value();
        long start = System.currentTimeMillis();
        try{
            return joinPoint.proceed();
        } finally {
            long end = System.currentTimeMillis();
            System.out.println("[TimeCost] " + s + "执行所需时间: " + (end - start));
        }
    }
}
