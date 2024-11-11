package com.mySpring.context;

/**
 * @Author: Jia Yuning
 * @Description:
 * @Date: 2023/07/15 22:41:10
 * @Version: 1.0.0
 */
public interface ApplicationContext {
    Object getBean(Class clazz);
}
