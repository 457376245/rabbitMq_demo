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
public class SubscribeConsumer {

    SubscribeConsumer() {
        super();
        System.out.println("SubscribeConsumer初始化成功");
    }
    @RabbitListener(queues = {RabbitConstant.PUBLISH_SUBSCRIBE_FIRST_QUEUE_NAME})
    @RabbitHandler
    public void subscribeConsumer1(String message){
        System.out.println("subscribeConsumer1:"+message);
    }

    @RabbitListener(queues = {RabbitConstant.PUBLISH_SUBSCRIBE_SECOND_QUEUE_NAME})
    @RabbitHandler
    public void subscribeConsumer2(String message){
        System.out.println("subscribeConsumer2:"+message);
    }
}
