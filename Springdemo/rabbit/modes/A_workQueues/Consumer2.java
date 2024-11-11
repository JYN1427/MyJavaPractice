package com.example.springdemo.A_middleware.rabbit.modes.A_workQueues;

import com.example.springdemo.A_middleware.rabbit.ConnectionUtil;
import com.rabbitmq.client.*;

import java.io.IOException;

public class Consumer2 {
    public static void main(String[] args) throws Exception {
        doConsume();
    }

    public static void doConsume() throws Exception{

        //1.创建连接工厂
        ConnectionFactory factory = new ConnectionFactory();
        //2. 设置参数
        factory.setHost(ConnectionUtil.HOST);//ip
        factory.setPort(ConnectionUtil.PORT); //端口  默认值 5672
        factory.setVirtualHost(ConnectionUtil.VHOST);//虚拟机 默认值/
        factory.setUsername(ConnectionUtil.USERNAME);//用户名
        factory.setPassword(ConnectionUtil.PASSWORD);//密码
        //3. 创建连接 Connection
        Connection connection = factory.newConnection();
        //4. 创建Channel
        Channel channel = connection.createChannel();
        //5. 创建队列Queue
        /*
        queueDeclare(String queue, boolean durable, boolean exclusive, boolean autoDelete, Map<String, Object> arguments)
        参数：
            1. queue：队列名称
            2. durable：是否持久化,当mq重启之后,还在
            3. exclusive：
                * 是否独占。只能有一个消费者监听这队列
                * 当Connection关闭时,是否删除队列
            4. autoDelete：是否自动删除。当没有Consumer时,自动删除掉
            5. arguments：参数。
         */
        //如果没有一个名字叫simple_queue的队列,则会创建该队列,如果有则不会创建
        channel.queueDeclare("simple_queue",true,false,false,null);

        // 接收消息
        DefaultConsumer consumer = new DefaultConsumer(channel) {
            /*
               回调方法,当收到消息后,会自动执行该方法
               1. consumerTag：标识
               2. envelope：获取一些信息,交换机,路由key...
               3. properties：配置信息
               4. body：数据
            */
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("consumerTag："+consumerTag);
                System.out.println("Exchange："+envelope.getExchange());
                System.out.println("RoutingKey："+envelope.getRoutingKey());
                System.out.println("properties："+properties);
                System.out.println("body："+new String(body));
            }
        };
        /*
        basicConsume(String queue, boolean autoAck, Consumer callback)
        参数：
            1. queue：队列名称
            2. autoAck：是否自动确认 ,类似咱们发短信,发送成功会收到一个确认消息
            3. callback：回调对象
         */
        // 消费者类似一个监听程序,主要是用来监听消息
        channel.basicConsume("simple_queue",true,consumer);
    }

}
