package com.yclooper.springjwt.service.iml;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.yclooper.springjwt.entity.User;
import com.yclooper.springjwt.service.UserService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by chen on 2020/8/5.
 */
@Service("userServiceImpl")
public class UserServiceImpl implements UserService {
    HashMap<Integer, User> map = new HashMap<>();
    {
        User user = new User();
        user.setId(1);
        user.setUsername("张三");
        user.setPassword("123456");
        map.put(user.getId(), user);
    }

    @Override
    public String generateToken(User user) {
        return JWT.create().withAudience(user.getId()+"").sign(Algorithm.HMAC256(user.getPassword()));
    }

    @Override
    public User findUserById(int userId) {
        return map.get(userId);
    }

    @Override
    public User login(String username) {
        Set<Map.Entry<Integer, User>> entries = map.entrySet();
        for (Map.Entry<Integer, User> entry : entries) {
            if (entry.getValue().getUsername().equals(username)) {
                return entry.getValue();
            }
        }
        return null;
    }
}
