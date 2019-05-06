package com.yclooper.springconsumer;

import org.springframework.stereotype.Component;

/**
 * Created by chen on 2019/5/6.
 */
@Component
public class HelloRemoteHystrix implements HelloRemote {
    @Override
    public String hello(String name) {
        return "hello,this is from hystrix "+name;
    }
}
