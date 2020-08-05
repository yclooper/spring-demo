package com.yclooper.springjwt.exception;

/**
 * Created by chen on 2020/8/5.
 */
public class LoginException extends Exception{

    public LoginException(String message) {
        super(message);
    }

    public LoginException(String message, Throwable throwable) {
        super(message,throwable);
    }
}
