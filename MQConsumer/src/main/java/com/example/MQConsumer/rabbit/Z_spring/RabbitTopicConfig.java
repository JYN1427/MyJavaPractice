package com.example.MQConsumer.rabbit.Z_spring;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * TODO
 *
 * @author jiayn01
 * @date 2024-06-13 15:32:44
 */
// @Configuration
public class RabbitTopicConfig {

    public static final String topicA = "hello.world";
    public static final String topicB = "hello.#";

    /**
     *  @Description: 主题交换机
     */
    @Bean
    public TopicExchange topicExchange1(){
        return new TopicExchange("topic_exchange");
    }

    @Bean
    public Queue topicQueue1(){
        return new Queue("topic_queue1");
    }

    @Bean
    public Queue topicQueue2(){
        return new Queue("topic_queue2");
    }

    @Bean
    public Binding topicBinding1(){
        return BindingBuilder
                .bind(topicQueue1())
                .to(topicExchange1())
                .with(topicA);
    }

    @Bean
    public Binding topicBinding2(){
        return BindingBuilder
                .bind(topicQueue2())
                .to(topicExchange1())
                .with(topicB);
    }
}
