package com.example.MQConsumer.properties.propertySource;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

/**
 * 见TestEnvConfig备注
 *
 * @author jiayn01
 * @date 2023-10-20 18:03:27
 */

@Profile("prod")
@Configuration
@PropertySource(value = {"classpath:envConfig/test/test.properties", "classpath:envConfig/test/http.properties"}, encoding = "utf-8")
public class ProdEnvConfig {
}
