package com.wqm.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wqm.common.Dto.AddNewMessageDto;
import com.wqm.common.Dto.GetMyDynamicDto;
import com.wqm.common.Result;
import com.wqm.common.vo.MyFriendVo;
import com.wqm.common.vo.MyMessageVo;
import com.wqm.entity.Friend;
import com.wqm.entity.Message;
import com.wqm.entity.User;
import com.wqm.mapper.FriendMapper;
import com.wqm.mapper.MessageMapper;
import com.wqm.service.MessageService;
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
 * 消息控制类，实现消息关系的相关操作接口
 */
@RestController
@RequestMapping("/message")
public class MessageController {

    @Autowired
    UserService userService;
    @Autowired
    MessageService messageService;
    @PostMapping("/addNewMessage")
    public Result addNewFriend(@Validated @RequestBody AddNewMessageDto addNewMessageDto) {

        User user1 = userService.getOne(new QueryWrapper<User>().eq("username", addNewMessageDto.getMyUsername()));
        User user2 = userService.getOne(new QueryWrapper<User>().eq("username", addNewMessageDto.getUsername()));

        try {
            Assert.notNull(user2, "用户不存在");
        } catch (Exception e) {
            return Result.fail("用户不存在");
        }


        Message message = new Message(null,user1.getId(), user2.getId(), addNewMessageDto.getMessage(),addNewMessageDto.getTime());
        messageService.save(message);
        return Result.succ(null);
    }

    @Autowired
    MessageMapper messageMapper;
    @PostMapping("/getMyMessage")
    public Result getMyMessage(@Validated @RequestBody GetMyDynamicDto getMyDynamicDto) {

        List<MyMessageVo> myFriendVos = messageMapper.selectMyMessage(getMyDynamicDto.getUid());
        return Result.succ(myFriendVos);
    }

}
