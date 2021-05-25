package com.wqm.mapper;

import com.wqm.entity.Dynamic;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wqm.common.vo.DynamicVo;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 王前明
 * @since 2021-05-15
 */
public interface DynamicMapper extends BaseMapper<Dynamic> {
    List<DynamicVo> selectAllDynamic();

}
