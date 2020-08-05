package com.yclooper.springjwt.service;

import com.yclooper.springjwt.entity.User;

/**
 * Created by chen on 2020/8/5.
 */
public interface UserService {

    String generateToken(User user);

    User findUserById(int userId);

    User login(String username);
}
