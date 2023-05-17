package com.jh.rabbitmq_demo.config;

import com.jh.rabbitmq_demo.RabbitConstant;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Program: rabbitmq_demo
 * @ClassName: QueueConfig
 * @Author: JH
 * @Date: 2023-05-17 10:12
 * @Description:
 */
@Configuration
public class QueueConfig {
    
    @Bean
    public Queue simpleQueue(){
        return new Queue(RabbitConstant.SIMPLE_QUEUE_NAME);
    }

    @Bean
    public Queue workQueue(){
        return new Queue(RabbitConstant.WORK_QUEUE_NAME);
    }


    /**
     * 发布订阅模式的2个队列，绑定到一个交换机上
     * @return
     */
    @Bean
    public Queue subscribeQueue1(){
        return new Queue(RabbitConstant.PUBLISH_SUBSCRIBE_FIRST_QUEUE_NAME);
    }
    @Bean
    public Queue subscribeQueue2(){
        return new Queue(RabbitConstant.PUBLISH_SUBSCRIBE_SECOND_QUEUE_NAME);
    }
    @Bean
    public FanoutExchange subscribeExchange(){
        return new FanoutExchange(RabbitConstant.PUBLISH_SUBSCRIBE_EXCHANGE_NAME);
    }
    @Bean
    public Binding queue1BindExchange(){
        return BindingBuilder.bind(subscribeQueue1()).to(subscribeExchange());
    }
    @Bean
    public Binding queue2BindExchange(){
        return BindingBuilder.bind(subscribeQueue2()).to(subscribeExchange());
    }


    /**
     * 路由模式的2个队列，绑定到一个交换机上
     * @return
     */
    @Bean
    public Queue routeQueue1(){
        return new Queue(RabbitConstant.ROUTING_FIRST_QUEUE_NAME);
    }
    @Bean
    public Queue routeQueue2(){
        return new Queue(RabbitConstant.ROUTING_SECOND_QUEUE_NAME);
    }
    @Bean
    public DirectExchange routeExchange(){
        return new DirectExchange(RabbitConstant.ROUTING_EXCHANGE_NAME);
    }
    @Bean
    public Binding queue1BindExchangeWithRouteKey(){
        return BindingBuilder.bind(routeQueue1()).to(routeExchange()).with(RabbitConstant.ROUTING_FIRST_QUEUE_ROUTING_KEY_NAME);
    }
    @Bean
    public Binding queue2BindExchangeWithRouteKey(){
        return BindingBuilder.bind(routeQueue2()).to(routeExchange()).with(RabbitConstant.ROUTING_SECOND_QUEUE_ROUTING_KEY_NAME);
    }

}
