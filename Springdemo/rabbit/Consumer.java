package com.example.springdemo.A_middleware.rabbit;

import com.rabbitmq.client.*;

/**
 * @Author: Jia Yuning
 * @Description:
 * @Date: 2024/06/10 15:27:10
 * @Version: 1.0.0
 */
public class Consumer {
    private final static String QUEUE_NAME = "hello_queue";

    public static void main(String[] args) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHandshakeTimeout(300000000);//设置握手超时时间
        factory.setHost("192.168.1.73");
        factory.setPort(5672);
        factory.setUsername("admin");
        factory.setPassword("123");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        System.out.println("等待接收消息.........");

        //推送的消息如何进行消费的接口回调
        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            String message = new String(delivery.getBody());
            System.out.println(message);
        };

        //取消消费的一个回调接口 如在消费的时候队列被删除掉了
        CancelCallback cancelCallback = (consumerTag) -> System.out.println("消息消费被中断");

        /**
         * 消费者消费消息
         * 1.消费哪个队列
         * 2.消费成功之后是否要自动应答 true 代表自动应答 false 手动应答
         * 3.消费者未成功消费的回调
         */
        channel.basicConsume(QUEUE_NAME, true, deliverCallback, cancelCallback);
    }
}