package com.example.SpringDemosProject.importAnno.dynamicUse.ImportSelector.service;

/**
 * @Author: Jia Yuning
 * @Description:
 * @Date: 2023/08/20 22:10:31
 * @Version: 1.0.0
 */
public class RedisCacheServiceImpl implements MyCacheService{
    @Override
    public void useCache() {
        System.out.println("Use Redis Cache...");
    }
}
