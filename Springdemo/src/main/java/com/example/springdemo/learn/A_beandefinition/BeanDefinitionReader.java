package com.example.springdemo.learn.A_beandefinition;

import com.example.springdemo.learn.zzzbean.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.support.SimpleBeanDefinitionRegistry;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotatedBeanDefinitionReader;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;

import java.util.Arrays;

/**
 * @Author: Jia Yuning
 * @Description:
 * @Date: 2024/05/28 22:16:06
 * @Version: 1.0.0
 */
@Slf4j
public class BeanDefinitionReader {
    public static void main(String[] args) {

    }


    /**
     * XmlBeanDefinitionReader
     * 通过xml注册BeanDefinition
     */
    @Test
    public void testBeanDefinitionReader() {
        // 1、创建一个beanDefinitionRegistry
        SimpleBeanDefinitionRegistry registry = new SimpleBeanDefinitionRegistry();
        // 2、创建一个beanDefinitionReader
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(registry);
        // 3、加载xml中的beanDefinition
        beanDefinitionReader.loadBeanDefinitions("bean.xml");
        log.info("加载了{}个beanDefinition",registry.getBeanDefinitionCount());
    }


    /**
     * AnnotatedBeanDefinitionReader
     * 通过注解注册BeanDefinition
     */
    @Test
    public void testRegistryByAnnotation(){
        // 1、定义一个注册器，用来注册和管理BeanDefinition
        SimpleBeanDefinitionRegistry registry = new SimpleBeanDefinitionRegistry();

        // 2、通过一个带有注解的bean进行注册
        AnnotatedBeanDefinitionReader annoReader = new AnnotatedBeanDefinitionReader(registry);
        annoReader.register(User.class);
        log.info(Arrays.toString(registry.getBeanDefinitionNames()));
    }

    /**
     * ClassPathBeanDefinitionScanner
     * 通过扫描包注册BeanDefinition, 包路径下被注解声明为Bean的类都会被注册, 但不包括配置类中被@Bean修饰的类
     */
    @Test
    public void testClassPathBeanDefinitionScanner() {
        // 1、创建一个beanDefinitionRegistry
        SimpleBeanDefinitionRegistry registry = new SimpleBeanDefinitionRegistry();
        // 2、创建一个beanDefinitionReader
        ClassPathBeanDefinitionScanner scanner = new ClassPathBeanDefinitionScanner(registry);
        // 3、扫描com.ydlclass.bean这个包下的bean
        scanner.scan("com.example.springdemo.learn");
        System.out.println(registry.getBeanDefinitionCount());
    }


}
