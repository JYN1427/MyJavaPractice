package com.example.SpringDemosProject.importAnno.dynamicUse.ImportSelector;

import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author: Jia Yuning
 * @Description:
 * @Date: 2023/08/20 22:14:37
 * @Version: 1.0.0
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Import({MyImportSelector.class})
public @interface EnableMyCache {
    // 指定使用缓存类型
    CacheType type();

    // 描述
    String desc();
}


