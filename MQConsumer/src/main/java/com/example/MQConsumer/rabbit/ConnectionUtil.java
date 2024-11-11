package com.example.MQConsumer.rabbit;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * TODO
 *
 * @author jiayn01
 * @date 2024-06-11 14:23:46
 */
public class ConnectionUtil {

    public static ConnectionFactory factory;

    public static final String USERNAME = "mquser";

    public static final String PASSWORD = "mquser123";

    public static final String VHOST = "/";

    public static final String HOST = "10.0.193.184";

    public static final int PORT = 5672;

    static {
        factory = new ConnectionFactory();
        factory.setHost(ConnectionUtil.HOST);//ip
        factory.setPort(ConnectionUtil.PORT); //端口  默认值 5672
        factory.setVirtualHost(ConnectionUtil.VHOST);//虚拟机 默认值/
        factory.setUsername(ConnectionUtil.USERNAME);//用户名
        factory.setPassword(ConnectionUtil.PASSWORD);//密码
    }

    public static Connection getConnection() throws Exception {
        Connection connection = factory.newConnection();
        return connection;
    }

}
