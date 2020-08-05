package com.yclooper.springredis;

import java.io.Serializable;

/**
 * Created by chen on 2019/7/26.
 */
public class User implements Serializable {

    private static final Long serializableUID=1L;

    public String username;
    public String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
