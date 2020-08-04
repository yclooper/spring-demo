package com.yclooper.springshiro.Controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("/login")
    public String login(String username, String password) {
        try {
            Subject subject = SecurityUtils.getSubject();
            subject.login(new UsernamePasswordToken(username, password));
            return "success";
        } catch (UnknownAccountException e) {
            return "没有此账号";
        } catch (DisabledAccountException e) {
            return "账号不可用";
        } catch (IncorrectCredentialsException e) {
            return "非法认证信息";
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            return "未知错误";
        }
    }

    @RequestMapping("/hello")
    @RequiresRoles("user")
    public String hello() {
        return "hello";
    }
    @RequestMapping("/hi")
    @RequiresRoles("admin")
    public String hi() {
        return "hi";
    }
    @RequestMapping("/notLogin")
    public String notLogin() {
        return "没有登录";
    }

    @RequestMapping("/notAuth")
    public String notAuth() {
        return "没有权限";
    }

}
