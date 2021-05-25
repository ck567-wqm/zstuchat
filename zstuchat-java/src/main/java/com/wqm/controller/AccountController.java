package com.wqm.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wqm.common.Dto.LoginDto;
import com.wqm.common.Dto.RegisterDto;
import com.wqm.common.Result;
import com.wqm.entity.User;
import com.wqm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 王前明
 * 账户控制类，管理登录和注册接口
 */
@RestController
public class AccountController {

    @Autowired
    UserService userService;

    @PostMapping("/login")
    public Result login(@Validated @RequestBody LoginDto loginDto) {

        User user = userService.getOne(new QueryWrapper<User>().eq("username", loginDto.getUsername()));

        Assert.notNull(user, "用户不存在");

        if (!user.getPassword().equals(loginDto.getPassword())) {
            return Result.fail("密码不正确");
        }

        return Result.succ(user);
    }

    @PostMapping("/register")
    public Result register(@Validated @RequestBody RegisterDto registerDto) {
        //防止用户名重复
        User user1 = userService.getOne(new QueryWrapper<User>().eq("username", registerDto.getUsername()));
        try {
            Assert.isNull(user1, "用户名已存在");
        } catch (Exception e) {
            return Result.fail(410, "用户名已存在", null);
        }

        User user = new User(null, registerDto.getUsername(), registerDto.getPassword());
        userService.save(user);
        return Result.succ(user);
    }

}

