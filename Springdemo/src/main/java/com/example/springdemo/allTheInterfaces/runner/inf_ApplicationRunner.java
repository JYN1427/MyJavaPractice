package com.example.springdemo.allTheInterfaces.runner;

import com.example.springdemo.allTheInterfaces.A_common.Const;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @Author: Jia Yuning
 * @Description:
 * @Date: 2023/08/26 21:01:33
 * @Version: 1.0.0
 */
@Component
@Order(value = 1)
public class inf_ApplicationRunner implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println(Const.PRE_STR + " 实现了ApplicationRunner接口的类 的 run 方法中执行");
    }
}