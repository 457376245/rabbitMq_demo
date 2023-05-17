package com.jh.rabbitmq_demo.util;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class RabbitMqUtil {
    private static ConnectionFactory connectionFactory;
    private static String host = "127.0.0.1";
    private static String username = "user";
    private static String password = "user";
    private static String virtuallHost = "/test_virtual";
    private static int port=5672;
    static {
        connectionFactory = new ConnectionFactory();
        connectionFactory.setHost(host);
        connectionFactory.setPort(port);
        connectionFactory.setUsername(username);
        connectionFactory.setPassword(password);
        connectionFactory.setVirtualHost(virtuallHost);
    }

    public static Connection getConnection() throws IOException, TimeoutException {
        return connectionFactory.newConnection();
    }
    public static Channel getChannel() throws IOException, TimeoutException {
       return getConnection().createChannel();
    }
    public static void closeConnetionAndChannel(Channel channel,Connection connection){
        try {
            if (channel!=null){channel.close();}
            if (connection!=null){connection.close();}

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}