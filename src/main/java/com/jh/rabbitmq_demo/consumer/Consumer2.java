package com.jh.rabbitmq_demo.consumer;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @Program: rabbitmq_demo
 * @ClassName: Consumer
 * @Author: JH
 * @Date: 2023-05-12 16:19
 * @Description:
 */
public class Consumer2 {
    public static void main(String[] args) throws IOException, TimeoutException {
        //创建连接工厂
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("127.0.0.1");
        connectionFactory.setPort(5672);
        connectionFactory.setUsername("user");
        connectionFactory.setPassword("user");
        connectionFactory.setVirtualHost("/test_virtual");
        //创建连接对象
        Connection connection = connectionFactory.newConnection();
        //创建通道  
        Channel channel = connection.createChannel();
        /* 绑定通道
        '参数1':用来声明通道对应的队列
        '参数2':用来指定是否持久化队列
        '参数3':用来指定是否独占队列
        '参数4':用来指定是否自动删除队列
        '参数5':对队列的额外配置*/
        channel.queueDeclare("hello", true, false, false, null);
        //消费消息
        channel.basicConsume("hello",true,new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope,
                                       AMQP.BasicProperties properties, byte[] body) throws IOException {
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                System.out.println(2+new String(body));
            }
        });
    }
}
