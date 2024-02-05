package org.example.spi.env;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.PropertiesPropertySource;

import java.util.Properties;

/**
 * @Author: Jia Yuning
 * @Description:
 * @Date: 2023/08/31 21:47:15
 * @Version: 1.0.0
 */
public class MyEnvironmentPostProcessor implements EnvironmentPostProcessor {
    @Override
    public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {
        Properties properties = new Properties();
        properties.put("EnvironmentPostProcessor.key1", "EnvironmentPostProcessor-value1");
        properties.put("EnvironmentPostProcessor.key2", "EnvironmentPostProcessor-value2");
        environment.getPropertySources().addLast(new PropertiesPropertySource("myProperties", properties));
    }
}
