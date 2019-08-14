package com.yclooper.springrabbitmq.topic;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by chen on 2019/8/6.
 */
@Component
@RabbitListener(queues = "object")
public class HelloReceiverC {


    @RabbitHandler
    public void process(User user) {
        System.out.println("receiver2:" + user);
    }

}

