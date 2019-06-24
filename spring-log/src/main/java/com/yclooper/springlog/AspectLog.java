package com.yclooper.springlog;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by chen on 2019/6/24.
 */
//@Component
//@Aspect
//@Order(1)
public class AspectLog {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private final ObjectMapper mapper;

    private AspectLog(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    @Pointcut("@annotation(org.springframework.web.bind.annotation.RequestMapping)")
    public void webLog() {

    }

    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint) {
        for (Object object : joinPoint.getArgs()) {
            if (object instanceof MultipartFile || object instanceof HttpServletRequest || object instanceof HttpServletResponse) {
                continue;
            }
        }
        try {
            logger.info(joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName()
                    + ":request params" + mapper.writeValueAsString(joinPoint.getArgs()));
            logger.info("requestSource:" + joinPoint.getSourceLocation());
        } catch (Exception e) {

        }
    }

    @AfterReturning(returning = "object", pointcut = "webLog()")
    public void doAfterReturn(Object object) throws Throwable {
        logger.info("response result:" + mapper.writeValueAsString(object));
    }
}

