package com.wqm.service.impl;

import com.wqm.entity.Message;
import com.wqm.mapper.MessageMapper;
import com.wqm.service.MessageService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 王前明
 * @since 2021-05-24
 */
@Service
public class MessageServiceImpl extends ServiceImpl<MessageMapper, Message> implements MessageService {

}
