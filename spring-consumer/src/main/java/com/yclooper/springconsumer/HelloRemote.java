package com.yclooper.springconsumer;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "spring-provider",fallback = HelloRemoteHystrix.class)
public interface HelloRemote {

    @RequestMapping("/hello")
    String hello(@RequestParam(value = "name") String name);
}
