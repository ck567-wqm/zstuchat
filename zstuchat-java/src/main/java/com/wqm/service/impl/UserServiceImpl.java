package com.wqm.service.impl;

import com.wqm.entity.User;
import com.wqm.mapper.UserMapper;
import com.wqm.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 王前明
 * @since 2021-05-11
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
