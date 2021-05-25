package com.wqm.mapper;

import com.wqm.common.vo.MyFriendVo;
import com.wqm.entity.Friend;
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
public interface FriendMapper extends BaseMapper<Friend> {
    List<MyFriendVo> selectMyFriend(@Param("id") int id);
}
