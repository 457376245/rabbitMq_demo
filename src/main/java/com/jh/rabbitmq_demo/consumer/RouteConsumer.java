package com.jh.rabbitmq_demo.consumer;

import com.jh.rabbitmq_demo.RabbitConstant;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Program: rabbitmq_demo
 * @ClassName: SubscribeConsumer
 * @Author: JH
 * @Date: 2023-05-17 10:58
 * @Description:
 */
@Component
public class RouteConsumer {

    RouteConsumer() {
        super();
        System.out.println("RouteConsumer初始化成功");
    }
    @RabbitListener(queues = {RabbitConstant.ROUTING_FIRST_QUEUE_NAME})
    @RabbitHandler
    public void routeConsumer1(String message){
        System.out.println("routeConsumer1:"+message);
    }

    @RabbitListener(queues = {RabbitConstant.ROUTING_SECOND_QUEUE_NAME})
    @RabbitHandler
    public void routeConsumer2(String message){
        System.out.println("routeConsumer2:"+message);
    }
}
