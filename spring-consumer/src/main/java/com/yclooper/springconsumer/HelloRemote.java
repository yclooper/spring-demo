package com.yclooper.springconsumer;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("spring-provider")
public interface HelloRemote {

    @RequestMapping("/hello")
    public String hello(@RequestParam(value = "name") String name);
}
