package com.yclooper.springrabbitmq.topic;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by chen on 2019/8/6.
 */
@Component
@RabbitListener(queues = "hello")
public class HelloReceiver {


    @RabbitHandler
    public void process(String hello) {
        System.out.println("receiver1:" + hello);
    }

}

