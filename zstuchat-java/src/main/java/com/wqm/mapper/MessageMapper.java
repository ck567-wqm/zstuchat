package com.wqm.mapper;

import com.wqm.common.vo.MyFriendVo;
import com.wqm.common.vo.MyMessageVo;
import com.wqm.entity.Message;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 王前明
 * @since 2021-05-24
 */
public interface MessageMapper extends BaseMapper<Message> {
    List<MyMessageVo> selectMyMessage(@Param("id") int id);
}
