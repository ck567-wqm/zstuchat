package com.wqm.mapper;

import com.wqm.common.vo.CommentVo;
import com.wqm.entity.Comment;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 王前明
 * @since 2021-05-15
 */
public interface CommentMapper extends BaseMapper<Comment> {
    List<CommentVo> selectAllComment();
}
