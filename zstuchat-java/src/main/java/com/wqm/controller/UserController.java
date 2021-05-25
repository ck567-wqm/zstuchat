package com.wqm.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wqm.common.Dto.*;
import com.wqm.common.Result;
import com.wqm.entity.User;
import com.wqm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author 王前明
 * @since 2021-05-11
 * user控制类，实现user相关的操作接口
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/update/email")
    public Result emailUpdate(@Validated @RequestBody EmailUpdateDto emailUpdateDto) {

        User user = userService.getOne(new QueryWrapper<User>().eq("id", emailUpdateDto.getId()));
        user.setEmail(emailUpdateDto.getEmail());
        userService.updateById(user);
        return Result.succ(user);
    }

    @PostMapping("/update/pwd")
    public Result pwdUpdate(@Validated @RequestBody pwdUpdateDto pwdUpdateDto) {

        User user = userService.getOne(new QueryWrapper<User>().eq("id", pwdUpdateDto.getId()));
        if (!pwdUpdateDto.getPassword().equals(user.getPassword())) {
            return Result.fail("密码错误，修改密码失败！");
        }
        user.setPassword(pwdUpdateDto.getNewPassWord());
        userService.updateById(user);
        return Result.succ(user);
    }

    @PostMapping("/delete/user")
    public Result deleteUser(@Validated @RequestBody DeleteUserDto deleteUserDto) {

        User user = userService.getOne(new QueryWrapper<User>().eq("id", deleteUserDto.getId()));

        userService.removeById(user.getId());
        return Result.succ(user);
    }

    @PostMapping("/update/avatar")
    public Result updateAvatar(@Validated @RequestBody AvatarUpdateDto avatarUpdateDto) {

        User user = userService.getOne(new QueryWrapper<User>().eq("id", avatarUpdateDto.getId()));

        user.setAvatar(avatarUpdateDto.getImgUrl());
        userService.updateById(user);
        return Result.succ(user.getAvatar());
    }

    @PostMapping("/update/userinfo")
    public Result updateUserinfo(@Validated @RequestBody UpdateUserinfoDto updateUserinfoDto) {

        User user = userService.getOne(new QueryWrapper<User>().eq("id", updateUserinfoDto.getId()));

        user.setSignature(updateUserinfoDto.getSignature());
        user.setBirthday(updateUserinfoDto.getBirthday());
        user.setSex(updateUserinfoDto.getSex());
        userService.updateById(user);
        return Result.succ(user);
    }

}
