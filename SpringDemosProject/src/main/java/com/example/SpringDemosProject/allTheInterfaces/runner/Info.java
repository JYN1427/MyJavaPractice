package com.example.SpringDemosProject.allTheInterfaces.runner;

/**
 * runner说明
 *
 * @author jiayn01
 * @date 2023-08-29 16:55:02
 */
public class Info {

    /**
     * CommandLineRunner和ApplicationRunner的实现类是在SpringBoot应用初始化好上下文之后运行
     * 在org.springframework.boot.SpringApplication#run(java.lang.String...)里面可以看到对callRunners()方法的调用
     * callRunners()里面会找到实现CommandLineRunner和ApplicationRunner的Bean
     */


}
