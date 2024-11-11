package com.example.springdemo.learn.C_reflectTools;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.SimpleBeanDefinitionRegistry;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * @Author: Jia Yuning
 * @Description:
 * @Date: 2024/07/02 21:58:39
 * @Version: 1.0.0
 */
@Slf4j
public class BeanBatchCreate {
    public static void main(String[] args) throws ClassNotFoundException {
        // 1、创建一个beanDefinitionRegistry
        BeanDefinitionRegistry registry = new SimpleBeanDefinitionRegistry();

        // 2、创建一个beanDefinitionReader
        BeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(registry);
        beanDefinitionReader.loadBeanDefinitions("bean.xml");

        // 3、遍历beanDefinitionRegistry中的beanDefinition
        String[] beanDefinitionNames = registry.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            log.info("beanDefinitionName -> {}", beanDefinitionName);

            BeanDefinition beanDefinition = registry.getBeanDefinition(beanDefinitionName);

            // 4、对beanDefinition进行包装,进行实例化
            Class<?> beanClass = Class.forName(beanDefinition.getBeanClassName());
            BeanWrapper beanWrapper = new BeanWrapperImpl(beanClass);

            // 5、进行属性填充(异常，xml中读取的是统一的"1" "0.1" "aaa" --> 需要转换为各自的真实属性类型)
            // beanWrapper.setPropertyValues(beanDefinition.getPropertyValues());
            MutablePropertyValues propertyValues = beanDefinition.getPropertyValues();
            propertyValues.getPropertyValueList().forEach(propertyValue -> {
                log.info("\t propertyValue -> {}", propertyValue);
            });
            log.info("bean -> {}", beanWrapper.getWrappedInstance());

            log.info("================================");
        }
    }
}
