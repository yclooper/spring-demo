package com.yclooper.springshiro.Exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AuthExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public String authException(Exception e) {
        e.printStackTrace();
        return e.getMessage();
    }
}
