package com.example.springdemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 我一旦excludeName={org.example.spi.service.impl.MyServiceSecImpl},
 * MyServiceSecImpl这个类就不再通过SPI自动装配Bean进容器了。
 */
@SpringBootApplication(scanBasePackages = {"com.example", "org.example"}
//        , excludeName = {"org.example.spi.service.impl.MyServiceSecImpl"}
)
@MapperScan("com.example.springdemo.oracle.mapper")
public class SpringdemoApplication {
    public static void main(String[] args) {


        System.out.println("abc=" + System.getProperty("abc"));
        for (String arg : args) {
            System.out.println("arg----: " + arg);
        }


        SpringApplication.run(SpringdemoApplication.class, args);
    }

}
