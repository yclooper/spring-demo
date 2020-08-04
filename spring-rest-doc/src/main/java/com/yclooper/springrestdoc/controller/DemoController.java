package com.yclooper.springrestdoc.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by chen on 2019/7/9.
 */
@RestController
public class DemoController {


    @RequestMapping("/login")
    public Map<String, Object> login(String username, String password) {
        Map<String, Object> resultMap = new HashMap<>();
        if ("john".equals(username) && "123456".equals(password)) {
            resultMap.put("code", 1);
            resultMap.put("msg", "success");
            resultMap.put("data", null);
        }else {
            resultMap.put("code", 0);
            resultMap.put("msg", "false");
            resultMap.put("data", null);
        }
        return resultMap;
    }

}
