package com.example.springdemo.importAnno.dynamicUse.ImportSelector.service;

/**
 * @Author: Jia Yuning
 * @Description:
 * @Date: 2023/08/20 22:22:13
 * @Version: 1.0.0
 */
public class LocalCacheServiceImpl implements MyCacheService{
    @Override
    public void useCache() {
        System.out.println("Use Local Cache...");
    }
}
