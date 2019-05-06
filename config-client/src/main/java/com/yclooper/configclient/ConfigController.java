package com.yclooper.configclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/config")
public class ConfigController {

    @Value("${hello}")
    private String hello;

    @RequestMapping("/getConfig")
    public String getConfig() {
        return hello;
    }
}
