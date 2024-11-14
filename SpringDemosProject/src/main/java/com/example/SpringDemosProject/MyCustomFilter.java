package com.example.SpringDemosProject;

import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;
import org.springframework.core.io.Resource;
import org.springframework.core.type.ClassMetadata;

import java.io.IOException;

public class MyCustomFilter implements TypeFilter {

    @Override
    public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
        // 获取类的元数据
        ClassMetadata classMetadata = metadataReader.getClassMetadata();
        // 获取类的资源
        Resource resource = metadataReader.getResource();

        // 以下面的代码为例，假设你想排除com.example.exclude包下的所有类
        String className = classMetadata.getClassName();
        return !className.startsWith("com.example.springdemo.A_middleware.rabbit");
    }
}