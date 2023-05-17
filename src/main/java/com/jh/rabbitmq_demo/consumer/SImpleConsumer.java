package com.jh.rabbitmq_demo.consumer;

import com.jh.rabbitmq_demo.RabbitConstant;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @Program: rabbitmq_demo
 * @ClassName: Consumer
 * @Author: JH
 * @Date: 2023-05-12 16:19
 * @Description:生产者在单测处生产消息
 */
@Component
@RabbitListener(queues={RabbitConstant.SIMPLE_QUEUE_NAME})
public class SImpleConsumer {
    @Autowired
    @Qualifier("simpleQueue")
    private Queue queue;        
    SImpleConsumer() {
        super();
        System.out.println("simpleConsumer初始化成功");
    }

    @RabbitHandler
    public void receive1(String message){
        System.out.println("message = " + message);
    }
   
}
