package com.example.springdemo.importAnno.staticUse;

import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;

/**
 * @Author: Jia Yuning
 * @Description: 静态import的使用
 * @Date: 2023/08/20 10:31:29
 * @Version: 1.0.0
 */

@Import(value = {PersonObj.class})
@Component
public class ImportAnnoStaticLearn {

}

//
//class Test {
//    public static void main(String[] args) {
//        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ImportAnnoLearn.class);
////        ApplicationContext context = new AnnotationConfigApplicationContext("com.example.springdemo");
//        System.out.println("Ioc 容器初始化完成");
//        System.out.println("----------BeanDefinitionNames-----------");
//        String[] definitionNames = context.getBeanDefinitionNames();
//        for (String definitionName : definitionNames) {
//            System.out.println(definitionName);
//        }
//        System.out.println("----------Person对象-----------");
//        PersonObj person = context.getBean(PersonObj.class);
//        System.out.println("person===>"+person);
//        context.close();
//    }
//}
