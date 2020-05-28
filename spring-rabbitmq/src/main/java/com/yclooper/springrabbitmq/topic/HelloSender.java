package com.yclooper.springrabbitmq.topic;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.time.LocalDate;

/**
 * Created by chen on 2019/8/6.
 */
@Component
public class HelloSender {

    @Resource
    private AmqpTemplate amqpTemplate;

    public void send(Integer i) {
        String context = "hello" + LocalDate.now().toString();
        amqpTemplate.convertAndSend("hello", context+":"+i);
    }

    public void sendUser(User user) {
        amqpTemplate.convertAndSend("object", user);
    }
}
