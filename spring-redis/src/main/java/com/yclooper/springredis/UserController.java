package com.yclooper.springredis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * Created by chen on 2019/7/26.
 */
@RestController
public class UserController {

    @Autowired
    private RedisTemplate redisTemplate;


    @RequestMapping("/getUser")
    public User getUser() {
        ValueOperations<String,User> valueOperations = redisTemplate.opsForValue();
        return valueOperations.get("user");
    }


    @RequestMapping("/addUser")
    public String addUser() {
        User user = new User();
        user.setUsername("tom");
        user.setPassword("123456");
        ValueOperations<String, User> operations = redisTemplate.opsForValue();
        operations.set("user", user);
        return "success";
    }

    @RequestMapping("/getId")
    public String getId(HttpSession session) {
        if (session.getAttribute("id") == null) {
            session.setAttribute("id", 111);
            System.out.println("执行了session");
        }
        return session.getAttribute("id")+"";
    }
}
