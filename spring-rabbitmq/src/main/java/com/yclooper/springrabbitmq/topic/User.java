package com.yclooper.springrabbitmq.topic;

import java.io.Serializable;

/**
 * Created by chen on 2019/8/6.
 */
public class User implements Serializable {
    private String username;
    private String passWord;

    public User(String username, String passWord) {
        this.username=username;
        this.passWord=passWord;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", passWord='" + passWord + '\'' +
                '}';
    }
}
