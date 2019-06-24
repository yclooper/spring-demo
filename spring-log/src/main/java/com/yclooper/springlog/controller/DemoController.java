package com.yclooper.springlog.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by chen on 2019/6/24.
 */
@RestController
public class DemoController {

    @RequestMapping("/hello")
    public String hello(String name) {
        return "hello:" + name;
    }
}
