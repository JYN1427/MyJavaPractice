package com.mySpring.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author: Jia Yuning
 * @Description: 通过@Bean将该类对象交给容器管理
 * @Date: 2023/07/15 22:38:12
 * @Version: 1.0.0
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Bean {
}
