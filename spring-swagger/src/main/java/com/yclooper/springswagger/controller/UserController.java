package com.yclooper.springswagger.controller;

import com.yclooper.springswagger.entity.Result;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by chen on 2019/7/3.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @ApiOperation(value = "用户登录",notes = "note")
    @ApiImplicitParams({@ApiImplicitParam(name="username",value = "用户姓名",required = true),@ApiImplicitParam(name = "password",value = "用户密码")})
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public Result login(String username, String password) {
        return new Result();
    }
}
