package com.example.springdemo.allAnnotation.AllPropertiesAnno.propertySource;

import com.example.springdemo.allAnnotation.AllPropertiesAnno.enableConfigurationProperties.MyPropertiesClass;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;

/**
 * TODO
 *
 * @author jiayn01
 * @date 2023-10-20 18:18:32
 */

@SpringBootTest
public class propertiesTest {

    @Value("${global.user}")
    private String user;

    @Value("${jyn.favorite}")
    private String favorite;

    @Autowired
    private Environment environment;

    @Autowired
    private MyPropertiesClass myPropertiesClass;

    /**
     * JVM启动参数加spring.profiles.active=test
     */
    @Test
    public void test(){
        // @Value注入property属性
        System.out.println("global.user = " + user);
        System.out.println("jyn.favorite = " + favorite);

        // 从environment中拿属性
        System.out.println("当前environment中有效的profile包括:");
        for (String profileName : environment.getActiveProfiles()) {
            System.out.println(profileName);
        }

        // 把ConfigurationProperties配置类也注入进来
        System.out.println(myPropertiesClass.getName());
        System.out.println(myPropertiesClass.getAge());
    }
}
