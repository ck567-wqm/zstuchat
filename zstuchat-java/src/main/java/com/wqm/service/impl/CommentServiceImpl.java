package com.wqm.service.impl;

import com.wqm.entity.Comment;
import com.wqm.mapper.CommentMapper;
import com.wqm.service.CommentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 王前明
 * @since 2021-05-15
 */
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService {

}
