package com.example.springdemo.A_middleware.rabbit.modes.A_workQueues;

import com.example.springdemo.A_middleware.rabbit.ConnectionUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * TODO
 *
 * @author jiayn01
 * @date 2024-06-11 14:22:47
 */
public class Producer {

    public static void main(String[] args) throws Exception {
        for (int i = 0; i < 100; i++) {
            doProduce();
        }
    }

    public static void doProduce() throws Exception {
        //创建连接工厂
        ConnectionFactory factory = new ConnectionFactory();

        factory.setHost(ConnectionUtil.HOST);//ip
        factory.setPort(ConnectionUtil.PORT); //端口  默认值 5672
        factory.setVirtualHost(ConnectionUtil.VHOST);//虚拟机 默认值/
        factory.setUsername(ConnectionUtil.USERNAME);//用户名
        factory.setPassword(ConnectionUtil.PASSWORD);//密码

        //创建连接
        Connection connection = factory.newConnection();

        //创建频道
        Channel channel = connection.createChannel();

        // 声明（创建）队列
        /**
         * queue      参数1：队列名称
         * durable    参数2：是否定义持久化队列,当mq重启之后,还在
         * exclusive  参数3：是否独占本次连接
         *            ① 是否独占,只能有一个消费者监听这个队列
         *            ② 当connection关闭时,是否删除队列
         * autoDelete 参数4：是否在不使用的时候自动删除队列,当没有consumer时,自动删除
         * arguments  参数5：队列其它参数
         */
        channel.queueDeclare("simple_queue", true, false, false, null);

        // 要发送的信息
        String message = "你好；小兔子！- " + System.currentTimeMillis();
        /**
         * 参数1：交换机名称,如果没有指定则使用默认Default Exchage
         * 参数2：路由key,简单模式可以传递队列名称
         * 参数3：配置信息
         * 参数4：消息内容
         */
        channel.basicPublish("", "simple_queue", null, message.getBytes());
        System.out.println("已发送消息：" + message);

        // 关闭资源
        channel.close();
        connection.close();
    }
}