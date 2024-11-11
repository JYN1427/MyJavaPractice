package com.example.springdemo.learn.B_introspector;

import com.example.springdemo.learn.zzzbean.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.beans.*;

/**
 * 内省（Introspector）是Java语言中的一个特性，它允许程序员在运行时检查Java对象的类类型和类属性。
 * 这是通过Java的反射API来实现的
 *
 * @Author: Jia Yuning
 * @Description:
 * @Date: 2024/07/02 21:24:54
 * @Version: 1.0.0
 */
@Slf4j
public class IntrospectorTest {

    @Test
    public void test() throws Exception {
        // 获取BeanInfo
        BeanInfo beanInfo = Introspector.getBeanInfo(User.class);
        BeanDescriptor beanDescriptor = beanInfo.getBeanDescriptor();
        log.info("bean descriptor: {}", beanDescriptor);
        log.info("---------------------------------------------------");

        // 获取所有属性描述器
        PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
        for (PropertyDescriptor descriptor : propertyDescriptors) {
            log.info("property name: {}", descriptor.getName());
            log.info("property type: {}", descriptor.getPropertyType());
            log.info("property read method: {}", descriptor.getReadMethod());
            log.info("property write method: {}", descriptor.getWriteMethod());
            log.info("property descriptor: {}", descriptor);
            log.info("=======================================================");
        }

        // 通过新建一个属性描述器，并调用其setter方法 填充属性值
        User user = new User();
        PropertyDescriptor descriptor = new PropertyDescriptor("name", User.class);
        descriptor.getWriteMethod().invoke(user, "Jia Yuning");
        System.out.println(user);
    }
}
