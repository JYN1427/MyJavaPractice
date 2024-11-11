package com.example.springdemo.A_middleware.rabbit.config;

import com.example.springdemo.A_middleware.rabbit.spring.B_confirm_return.RabbitMQConfirmAndReturnImpl;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * TODO
 *
 * @author jiayn01
 * @date 2024-06-18 10:58:59
 */
@Configuration
public class RabbitMQBaseConfig {

    /**
     * 设置返回回调和确认回调
     *
     * @param connectionFactory
     * @return
     */
    @Bean
    RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory, RabbitMQConfirmAndReturnImpl rabbitMQConfirmAndReturn) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate();
        rabbitTemplate.setConnectionFactory(connectionFactory);
        rabbitTemplate.setConfirmCallback(rabbitMQConfirmAndReturn);
//        rabbitTemplate.setReturnCallback(rabbitMQConfirmAndReturn);  // ReturnCallback已经弃用, 改用ReturnsCallback
        rabbitTemplate.setReturnsCallback(rabbitMQConfirmAndReturn);

        //Mandatory为true时,消息通过交换器无法匹配到队列会返回给生产者，为false时匹配不到会直接被丢弃
         rabbitTemplate.setMandatory(true);
        // rabbitTemplate.setMessageConverter(jsonMessageConverter());

        return rabbitTemplate;
    }

}
