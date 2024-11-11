package com.example.JvmDemoProject.config;

import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.autoconfigure.metrics.MeterRegistryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * jvm监控配置类
 *
 * @Author: Jia Yuning
 * @Description:
 * @Date: 2024/08/02 22:31:04
 * @Version: 1.0.0
 */
@Configuration
public class JvmMonitorConfig {

    @Value("${spring.application.name}")
    private String applicationName;

    @Bean
    public MeterRegistryCustomizer<MeterRegistry> getConfig() {
        return registry -> registry.config().commonTags("application", applicationName);
    }

}
