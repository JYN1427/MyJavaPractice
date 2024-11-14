package com.example.SpringDemosProject.importAnno.dynamicUse.ImportSelector;

import com.example.SpringDemosProject.importAnno.dynamicUse.ImportSelector.service.LocalCacheServiceImpl;
import com.example.SpringDemosProject.importAnno.dynamicUse.ImportSelector.service.RedisCacheServiceImpl;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

/**
 * @Author: Jia Yuning
 * @Description:
 * @Date: 2023/08/20 21:52:55
 * @Version: 1.0.0
 */
public class MyImportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        // AnnotationMetadata 参数:
        // 一方面: 可以返回你config类上的所有注解, 也就是被@Import({MyImportSelector.class})修饰的类上的所有注解
        List<String> allAnnosList = new ArrayList<>(importingClassMetadata.getAnnotationTypes());
        Stream.iterate(0, n->n+1).limit(allAnnosList.size())
                .forEach(num -> {
                    System.out.println("---注解" + num + allAnnosList.get(num));
                });

        // 另一方面: 可以返回你指定注解的属性-赋值(k-v) Map
        // 用的比较多感觉
        Map<String, Object> annotationAttributes = importingClassMetadata.getAnnotationAttributes(EnableMyCache.class.getName());

        // desc-->使用本地注解、  type-->Local
        annotationAttributes.forEach((key, value) -> System.out.println(key + " --> " + value));

        // 后面你可以自定义一些判断逻辑，来对该类的注解信息进行过滤判断，来指定向导入哪些组件
        CacheType cacheType = (CacheType) annotationAttributes.get("type");
        switch (cacheType) {
            case Local:{
                System.out.println("使用本地缓存");
                return new String[]{LocalCacheServiceImpl.class.getName()};
            }
            case Redis:{
                System.out.println("使用Redis缓存");
                return new String[]{RedisCacheServiceImpl.class.getName()};
            }
            default:
                return new String[]{LocalCacheServiceImpl.class.getName()};
        }
    }
}
