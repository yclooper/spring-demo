package com.yclooper.springredis;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringRedisApplicationTests {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void contextLoads() {

    }

    @Test
    public void func1() {
        stringRedisTemplate.opsForValue().set("bb", "123");
        Assert.assertEquals("123", stringRedisTemplate.opsForValue().get("bb"));
        ValueOperations valueOperations = redisTemplate.opsForValue();
        System.out.println(valueOperations.size(String.class));

    }

    @Test
    public void func2() throws Exception{
        User user = new User("tom", "123456");
        ValueOperations<String,User> valueOperations=redisTemplate.opsForValue();
        valueOperations.set("user", user);

        valueOperations.set("user-t", user, 1, TimeUnit.SECONDS);

        Thread.sleep(1000);

        System.out.println(redisTemplate.opsForValue().get("user"));
        System.out.println(redisTemplate.opsForValue().get("user-t")==null);
    }


    @Test
    public void func3() {

    }

}
