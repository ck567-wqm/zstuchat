package com.wqm.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wqm.common.Dto.GetMyDynamicDto;
import com.wqm.common.Dto.AddNewFriendDto;
import com.wqm.common.Result;
import com.wqm.common.vo.MyFriendVo;
import com.wqm.entity.Friend;
import com.wqm.entity.User;
import com.wqm.mapper.FriendMapper;
import com.wqm.service.FriendService;
import com.wqm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 王前明
 * @since 2021-05-24
 * 好友控制类，实现好友关系的相关操作接口
 */
@RestController
@RequestMapping("/friend")
public class FriendController {

    @Autowired
    UserService userService;

    @Autowired
    FriendService friendService;
    @PostMapping("/addNewFriend")
    public Result addNewFriend(@Validated @RequestBody AddNewFriendDto addNewFriend) {

        User user1 = userService.getOne(new QueryWrapper<User>().eq("username", addNewFriend.getMyUsername()));
        User user2 = userService.getOne(new QueryWrapper<User>().eq("username", addNewFriend.getUsername()));

        try {
            Assert.notNull(user2, "用户不存在");
        } catch (Exception e) {
            return Result.fail("用户不存在");
        }


        Friend friend1 = friendService.getOne(new QueryWrapper<Friend>().eq("uid1",user1.getId()).eq("uid2",user2.getId()));

        try {
            Assert.isNull(friend1, "对方已经是你的好友");
        } catch (Exception e) {
            return Result.fail("对方已经是你的好友");
        }

        Friend friend = new Friend(null,user1.getId(), user2.getId(), addNewFriend.getTime());
        friendService.save(friend);

        return Result.succ(null);
    }

    @Autowired
    FriendMapper friendMapper;
    @PostMapping("/getMyFriend")
    public Result getMyFriend(@Validated @RequestBody GetMyDynamicDto getMyDynamicDto) {

        List<MyFriendVo> myFriendVos = friendMapper.selectMyFriend(getMyDynamicDto.getUid());
        return Result.succ(myFriendVos);
    }
}
