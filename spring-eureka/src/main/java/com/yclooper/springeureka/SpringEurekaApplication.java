package com.yclooper.springeureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@EnableEurekaServer
public class SpringEurekaApplication {

    public static void main(String[] args) {

        SpringApplication.run(SpringEurekaApplication.class, args);
    }

}
