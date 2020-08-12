package com.bean;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by chen on 2020/7/13.
 */
public class Cat {
    public Dog dog;
    private String name;
    private String color;


    public Cat() {
        System.out.println("cat constructor....");
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
