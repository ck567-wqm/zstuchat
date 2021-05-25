package com.wqm.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.wqm.common.Dto.AddNewCommentDto;
import com.wqm.common.Dto.AddNewDynamicDto;
import com.wqm.common.vo.DynamicVo;
import com.wqm.common.Dto.GetMyDynamicDto;
import com.wqm.common.Result;
import com.wqm.entity.Comment;
import com.wqm.entity.Dynamic;
import com.wqm.mapper.DynamicMapper;
import com.wqm.service.CommentService;
import com.wqm.service.DynamicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author 王前明
 * @since 2021-05-15
 * 留言板控制类，实现留言板操作的相关接口
 */
@RestController
@RequestMapping("/dynamic")
public class DynamicController {

    @Autowired
    DynamicService dynamicService;
    @Autowired
    CommentService commentService;

    @RequestMapping("/selectAllDynamic")
    public Result selectAllDynamic() {
        List<DynamicVo> dynamicVoList = dynamicService.selectAllDynamicAndComment();
        return Result.succ(dynamicVoList);
    }

    @RequestMapping("/addNewDynamic")
    public Result addNewDynamic(@Validated @RequestBody AddNewDynamicDto addNewDynamicDto) {
        Dynamic dynamic = new Dynamic(null, addNewDynamicDto.getMessage(), addNewDynamicDto.getTime(), addNewDynamicDto.getUid());
        dynamicService.save(dynamic);
        return Result.succ(null);
    }

    @RequestMapping("/addNewComment")
    public Result addNewComment(@Validated @RequestBody AddNewCommentDto addNewCommentDto) {
        Comment comment = new Comment(null, addNewCommentDto.getComment(), addNewCommentDto.getTime(), addNewCommentDto.getUid(), addNewCommentDto.getMid(), addNewCommentDto.getReply_id());
        commentService.save(comment);
        return Result.succ(null);
    }

    @Autowired
    DynamicMapper dynamicMapper;

    @PostMapping("/getMyDynamic")
    public Result getMyDynamic(@Validated @RequestBody GetMyDynamicDto getMyDynamicDto) {

        List<DynamicVo> dynamicVoList = dynamicMapper.selectAllDynamic();
        return Result.succ(dynamicVoList);
    }

}
