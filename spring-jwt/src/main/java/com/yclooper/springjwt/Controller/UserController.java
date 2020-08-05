package com.yclooper.springjwt.Controller;

import com.yclooper.springjwt.annotation.UserLoginToken;
import com.yclooper.springjwt.entity.User;
import com.yclooper.springjwt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by chen on 2020/8/5.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String login(String username, String password) {
        User user = userService.login(username);
        if (user == null) {
            return "无此用户";
        }
        if (!user.getPassword().equals(password)) {
            return "用户密码错误";
        }
        String  token = userService.generateToken(user);
        return "登录成功："+token;
    }

    @RequestMapping("/hello")
    @UserLoginToken
    public String hello() {
        return "hello";
    }
}
