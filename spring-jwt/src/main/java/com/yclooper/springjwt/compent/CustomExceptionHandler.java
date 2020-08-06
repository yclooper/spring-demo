package com.yclooper.springjwt.compent;

import com.yclooper.springjwt.exception.LoginException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Created by chen on 2020/8/6.
 */
@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(value = LoginException.class)
    public String loingException(Exception e) {
        e.printStackTrace();
        return e.getMessage();
    }
}
