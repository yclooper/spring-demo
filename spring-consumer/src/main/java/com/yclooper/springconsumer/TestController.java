package com.yclooper.springconsumer;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class TestController {

    @Resource
    private HelloRemote helloRemote;

    @RequestMapping("/hello")
    public String hello(String name) {
        return helloRemote.hello(name);
    }
}