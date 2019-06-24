package com.yclooper.springlog;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * Created by chen on 2019/6/24.
 */
@Aspect
@Component
@Order(2)
public class WebLogAspect {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private ThreadLocal<Long> treadLocal=new ThreadLocal<>();
    @Pointcut("execution(public * com.yclooper.springlog.controller..*.*(..))")
    public void webLog() {

    }


    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint) {
        treadLocal.set(System.currentTimeMillis());
        ServletRequestAttributes requestAttributes = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes());
        HttpServletRequest request = requestAttributes.getRequest();
        logger.info("URL: "+request.getRequestURI());
        logger.info("request mothed:" + request.getMethod());
        logger.info("IP:" + request.getRemoteAddr());
        logger.info("class_name:" + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        logger.info("args:" + Arrays.toString(joinPoint.getArgs()));
    }

    @AfterReturning(returning = "ret",pointcut = "webLog()")
    public void doAfterRunning(Object ret) throws Throwable{
        logger.info("response:" + ret.toString());
        System.out.println("run time" + (System.currentTimeMillis() - treadLocal.get()));
    }
}
