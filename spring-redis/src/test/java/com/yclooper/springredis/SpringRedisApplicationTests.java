package com.yclooper.springredis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringRedisApplicationTests {


    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void contextLoads() {

    }

    @Test
    public void func1() {
        System.out.println("------------------字符传------------------");
        redisTemplate.opsForValue().set("name", "张三");
        System.out.println(redisTemplate.opsForValue().get("name"));
        System.out.println("------------------字符传------------------");
        System.out.println("------------------HASH------------------");
        redisTemplate.opsForHash().put("hash", "username", "名字");
        System.out.println(redisTemplate.opsForHash().get("hash", "username"));
        System.out.println("------------------HASH------------------");
        System.out.println("------------------list------------------");
        for (int i = 0; i < 10; i++) {
            redisTemplate.opsForList().rightPush("list",i);
        }
        System.out.println(redisTemplate.opsForList().size("list"));
        for (int i = 0; i < 10; i++) {
            System.out.println(redisTemplate.opsForList().index("list", i));

        }
        System.out.println("------------------list------------------");


        redisTemplate.opsForSet().add("set", "a");
        redisTemplate.opsForSet().add("set", "b");
        redisTemplate.opsForSet().add("set", "a");

        System.out.println(redisTemplate.opsForSet().size("set"));
    }

    @Test
    public void func2() throws Exception{
        User user = new User();
        user.setUsername("tom");
        user.setPassword("123456");
        redisTemplate.opsForValue().set("user", user);

        System.out.println(redisTemplate.opsForValue().get("user"));
    }

    @Test
    public void func3() {
        User user = new User();
        user.setUsername("tom");
        user.setPassword("123456");
        Map<String, Object> map = new HashMap<>();
        map.put("username", user.getUsername());
        map.put("password", user.getPassword());
        redisTemplate.opsForHash().putAll("userHash", map);

        System.out.println(redisTemplate.opsForValue().get("userHash"));
    }

}
