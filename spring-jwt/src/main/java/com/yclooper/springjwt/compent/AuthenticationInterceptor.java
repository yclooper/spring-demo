package com.yclooper.springjwt.compent;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.yclooper.springjwt.annotation.PassToken;
import com.yclooper.springjwt.annotation.UserLoginToken;
import com.yclooper.springjwt.entity.User;
import com.yclooper.springjwt.exception.LoginException;
import com.yclooper.springjwt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.lang.reflect.Method;

/**
 * 拦截请求，解析验证token
 * Created by chen on 2020/8/5.
 */
public class AuthenticationInterceptor implements HandlerInterceptor {

    @Autowired
    private UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("token");
        //如果不是映射到方法，直接通过
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        HandlerMethod handlerMethod = ((HandlerMethod) handler);
        Method method = handlerMethod.getMethod();

        //检查passToken注解，跳过验证
        if (method.isAnnotationPresent(PassToken.class)) {
            PassToken passToken = method.getAnnotation(PassToken.class);
            if (passToken.required()) {
                return true;
            }
        }
        //检查userLoginToken,验证
        if (method.isAnnotationPresent(UserLoginToken.class)) {
            UserLoginToken methodAnnotation = handlerMethod.getMethodAnnotation(UserLoginToken.class);
            if (methodAnnotation.required()) {
                if (token == null) {
                    response.setContentType("application/json;charset=utf-8");
                    PrintWriter writer = response.getWriter();
                    writer.write("token is empty");
                    writer.close();
                    response.flushBuffer();
                    return false;
//                    throw  new LoginException("用户token为空，请登录");
                }
                String userId;
                try {
                    userId = JWT.decode(token).getAudience().get(0);
                } catch (JWTDecodeException e) {
                    throw new LoginException("用户不存在");
                }

                User user = userService.findUserById(Integer.parseInt(userId));
                if (user == null) {
                    throw new LoginException("用户不存在，请重新登陆");
                }
                JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(user.getPassword())).build();
                try {
                    jwtVerifier.verify(token);
                } catch (JWTVerificationException e) {
                    throw new LoginException("token验证失败");
                }
            }
        }
        return true;
    }
}
