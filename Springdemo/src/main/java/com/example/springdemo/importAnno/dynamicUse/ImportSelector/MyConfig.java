package com.example.springdemo.importAnno.dynamicUse.ImportSelector;

import org.springframework.context.annotation.Configuration;

/**
 * @Author: Jia Yuning
 * @Description: 在Config类上通过Import注解注入写好的ImportSelector
 * @Date: 2023/08/20 21:51:46
 * @Version: 1.0.0
 */

@EnableMyCache(type = CacheType.Local, desc = "使用本地注解")
@Configuration
public class MyConfig {
}
