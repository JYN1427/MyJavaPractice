package com.example.SpringDemosProject.allAnnotation.AllPropertiesAnno.propertySource;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

/**
 * Profile("test")注解使得spring.properties.active = test 的时候才注入该配置Bean
 * 即 JVM启动的Options参数加入 -Dspring.properties.active=test
 *
 * @author jiayn01
 * @date 2023-10-20 18:03:07
 */

@Profile("test")
@Configuration
@PropertySource(value = {"classpath:envConfig/test/test.properties", "classpath:envConfig/test/http.properties"}, encoding = "utf-8")
public class TestEnvConfig {
}
