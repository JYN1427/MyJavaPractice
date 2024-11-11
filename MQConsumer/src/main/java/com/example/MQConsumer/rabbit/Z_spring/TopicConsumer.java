package com.example.MQConsumer.rabbit.Z_spring;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.HashMap;

/**
 * 用的时候把@Component放开
 *
 * @author jiayn01
 * @date 2024-06-13 17:16:45
 */
// @Component
public class TopicConsumer {

    @RabbitHandler
    @RabbitListener(queues = "topic_queue1")
    public void getTopicQueue1(HashMap<String,String> topicMes1){
        System.out.println(" xxxxxxxx 消费 - 主题队列消息1:" + topicMes1);
    }

    @RabbitHandler
    @RabbitListener(queues = "topic_queue2")
    public void getTopicQueue2(HashMap<String,String>topicMes2){
        System.out.println(" xxxxxxxx 消费 - 主题消息队列2:" + topicMes2);
    }
}
