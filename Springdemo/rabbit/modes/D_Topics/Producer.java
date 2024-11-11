package com.example.springdemo.A_middleware.rabbit.modes.D_Topics;

import com.example.springdemo.A_middleware.rabbit.ConnectionUtil;
import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

public class Producer {
    public static void main(String[] args) throws Exception {
        Connection connection = ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();
        String exchangeName = "test_topic";
        channel.exchangeDeclare(exchangeName, BuiltinExchangeType.TOPIC, true, false, false, null);
        String queue1Name = "test_topic_queue1";
        String queue2Name = "test_topic_queue2";
        channel.queueDeclare(queue1Name, true, false, false, null);
        channel.queueDeclare(queue2Name, true, false, false, null);
        // 绑定队列和交换机
        /**
         *  参数：
         1. queue：队列名称
         2. exchange：交换机名称
         3. routingKey：路由键,绑定规则
         如果交换机的类型为fanout ,routingKey设置为""
         */
        // routing key  系统的名称.日志的级别。 比如 order.info, order.error, pay.info, pay.error ...

        // 队列1 所有error级别日志
        channel.queueBind(queue1Name, exchangeName, "#.error");

        // 队列2 订单系统的所有日志
        channel.queueBind(queue2Name, exchangeName, "order.*");


        String body1 = "日志信息：订单系统发单...日志级别：info...";
        String body2 = "日志信息：订单系统发单...日志级别：error...";
        String body3 = "日志信息：支付系统支付...日志级别：info...";
        String body4 = "日志信息：支付系统支付...日志级别：error...";


        //发送消息
        channel.basicPublish(exchangeName, "order.info", null, body1.getBytes());
        channel.basicPublish(exchangeName, "order.error", null, body2.getBytes());
        channel.basicPublish(exchangeName, "pay.info", null, body3.getBytes());
        channel.basicPublish(exchangeName, "pay.error", null, body4.getBytes());

        channel.close();
        connection.close();
    }
}
