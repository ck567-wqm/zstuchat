package com.wqm.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wqm.common.vo.CommentVo;
import com.wqm.common.vo.DynamicVo;
import com.wqm.entity.Dynamic;
import com.wqm.mapper.CommentMapper;
import com.wqm.mapper.DynamicMapper;
import com.wqm.service.DynamicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author 王前明
 * @since 2021-05-15
 */
@Service
public class DynamicServiceImpl extends ServiceImpl<DynamicMapper, Dynamic> implements DynamicService {

    @Autowired
    DynamicMapper dynamicMapper;

    @Autowired
    CommentMapper commentMapper;

    @Override
    public List<DynamicVo> selectAllDynamicAndComment() {
        List<DynamicVo> dynamicVoList = dynamicMapper.selectAllDynamic();
        List<CommentVo> commentVoList = commentMapper.selectAllComment();
        // 给所有评论添加回复名称
        commentVoList.forEach(val -> commentVoList.forEach(item -> {
            if (item.reply_id != null) {
                if (item.reply_id.equals(val.uid)) {//有待优化
                    item.reply_name = val.username;
                }
            }
        }));
        // 把所有评论数据插入留言列表中
        dynamicVoList.forEach(val -> {
            val.reply = new ArrayList<>();
            commentVoList.forEach(item -> {
                if (item.mid.equals(val.mid)) {
                    if (item.reply_id == null) {
                        item.reply_name = val.username;
                    }
                    val.reply.add(item);
                    System.out.println(item.reply_name);
                    System.out.println(item.reply_id);
                }
            });
        });
        dynamicVoList.forEach(System.out::println);
        return dynamicVoList;
    }
}
