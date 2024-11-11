package com.example.springdemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.core.type.filter.RegexPatternTypeFilter;

/**
 * 我一旦excludeName={org.example.spi.service.impl.MyServiceSecImpl},
 * MyServiceSecImpl这个类就不再通过SPI自动装配Bean进容器了。
 */
//@ComponentScan(excludeFilters = @ComponentScan.Filter(
//                type = FilterType.CUSTOM,
//                classes = MyCustomFilter.class)
//)
@SpringBootApplication(scanBasePackages = {"com.example", "org.example"})
@MapperScan(basePackages = {
        "com.example.springdemo.oracle.mapper",
        "com.example.springdemo.excel.mapper"
})
public class SpringdemoApplication {
    public static void main(String[] args) {


        System.out.println("abc=" + System.getProperty("abc"));
        for (String arg : args) {
            System.out.println("arg----: " + arg);
        }


        SpringApplication.run(SpringdemoApplication.class, args);
    }

}
