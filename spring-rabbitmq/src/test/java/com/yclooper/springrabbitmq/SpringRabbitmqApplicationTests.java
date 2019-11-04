package com.yclooper.springrabbitmq;

import com.yclooper.springrabbitmq.topic.HelloSender;
import com.yclooper.springrabbitmq.topic.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringRabbitmqApplicationTests {

    @Resource
    private HelloSender helloSender;

    @Test
    public void contextLoads() {

        for (int i = 0; i < 100; i++) {
            helloSender.send(i);
        }

    }

    @Test
    public void sendUser() {
        helloSender.sendUser(new User("34q24321", "34214312"));
    }

}
