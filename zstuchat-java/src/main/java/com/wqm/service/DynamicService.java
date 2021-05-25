package com.wqm.service;

import com.wqm.entity.Dynamic;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wqm.common.vo.DynamicVo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 王前明
 * @since 2021-05-15
 */
public interface DynamicService extends IService<Dynamic> {
    List<DynamicVo> selectAllDynamicAndComment();
}
