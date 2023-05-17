package com.jh.rabbitmq_demo;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RabbitmqDemoApplicationTests {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    void contextLoads() {
    }
    
    @Test
    void simplePublisherTest(){

        rabbitTemplate.convertAndSend(RabbitConstant.SIMPLE_QUEUE_NAME,"hello world");
        
    }
    @Test
    void workPublisherTest() throws InterruptedException {

        for (int i = 0; i <10 ; i++) {
            Thread.sleep(1000);
            rabbitTemplate.convertAndSend(RabbitConstant.WORK_QUEUE_NAME,"hello world"+i);
            System.out.println("消息发送成功："+i);
        }

    }

    @Test
    void subscribePublisherTest(){

        rabbitTemplate.convertAndSend(RabbitConstant.PUBLISH_SUBSCRIBE_EXCHANGE_NAME,null,"subscribeHello world");

    }

    @Test
    void routePublisherTest(){

        rabbitTemplate.convertAndSend(RabbitConstant.ROUTING_EXCHANGE_NAME,RabbitConstant.ROUTING_SECOND_QUEUE_ROUTING_KEY_NAME,"first route beHello world");

    }

}
