package com.example.springdemo.A_middleware.rabbit.modes.D_Topics;

import com.example.springdemo.A_middleware.rabbit.ConnectionUtil;
import com.rabbitmq.client.*;
import java.io.IOException;

/**
 * 消费订单系统的所有日志
 */
public class Consumer2 {
    public static void main(String[] args) throws Exception {
        Connection connection = ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();
        String queue2Name = "test_topic_queue2";
        Consumer consumer = new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("body："+new String(body));
            }
        };
        channel.basicConsume(queue2Name,true,consumer);
    }
}