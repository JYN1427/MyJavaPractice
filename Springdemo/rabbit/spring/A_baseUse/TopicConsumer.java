package com.example.springdemo.A_middleware.rabbit.spring.A_baseUse;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * TODO
 *
 * @author jiayn01
 * @date 2024-06-13 17:16:45
 */
@Component
public class TopicConsumer {

    @RabbitHandler
    @RabbitListener(queues = "topic_queue1")
    public void getTopicQueue1(Message message){
        System.out.println(" xxxxxxxx 消费 - 主题队列消息1:" + message.toString());
    }

    @RabbitHandler
    @RabbitListener(queues = "topic_queue2")
    public void getTopicQueue2(Message message){
        System.out.println(" xxxxxxxx 消费 - 主题消息队列2:" + message.toString());
    }
}
