package com.example.SpringDemosProject;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
        "com.example.SpringDemosProject.oracle.mapper",
        "com.example.SpringDemosProject.excel.mapper"
})
public class SpringDemosProjectApplication {
    public static void main(String[] args) {


        System.out.println("abc=" + System.getProperty("abc"));
        for (String arg : args) {
            System.out.println("arg----: " + arg);
        }


        SpringApplication.run(SpringDemosProjectApplication.class, args);
    }

}
