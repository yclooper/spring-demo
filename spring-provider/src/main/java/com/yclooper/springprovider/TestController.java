package com.yclooper.springprovider;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Value("${server.port}")
    private String port;
    @RequestMapping("/hello")
    public String hello(String name) {
        return "this provider return: " + port ;
    }
}
