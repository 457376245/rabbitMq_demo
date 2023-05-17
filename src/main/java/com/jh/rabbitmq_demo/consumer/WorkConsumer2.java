package com.jh.rabbitmq_demo.consumer;

import com.jh.rabbitmq_demo.RabbitConstant;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Program: rabbitmq_demo
 * @ClassName: Consumer
 * @Author: JH
 * @Date: 2023-05-12 16:19
 * @Description:生产者在单测处生产消息
 */
@Component
@RabbitListener(queues={RabbitConstant.WORK_QUEUE_NAME})
public class WorkConsumer2 {
    WorkConsumer2() {
        super();
        System.out.println("WorkConsumer2初始化成功");
    }

    @RabbitHandler
    public void receive1(String message){
        System.out.println("work2：message = " + message);
    }
   
}
