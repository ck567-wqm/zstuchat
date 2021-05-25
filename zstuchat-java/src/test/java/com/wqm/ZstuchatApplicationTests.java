package com.wqm;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.wqm.common.vo.DynamicVo;
import com.wqm.entity.Dynamic;
import com.wqm.entity.User;
import com.wqm.mapper.DynamicMapper;
import com.wqm.mapper.UserMapper;
import com.wqm.service.DynamicService;
import com.wqm.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@SpringBootTest
class ZstuchatApplicationTests {

    @Autowired
    UserService userService;


    @Test
    void contextLoads() {
        User user = new User(null,"wqm111","123");
        userService.saveOrUpdate(user);
    }

    @Autowired
    DynamicMapper dynamicMapper;
    @Test
    public void toTest(){
        List<DynamicVo> dynamicVoList = dynamicMapper.selectAllDynamic();
        dynamicVoList.forEach(System.out::println);
    }
    @Autowired
    UserMapper userMapper;
    @Test
    public void testSelect() {
        List<User> list = userMapper.selectList(null);
        list.forEach(System.out::println);
    }

    @Autowired
    DynamicService dynamicService;
    @Test
    public void testGetOne() {
        LambdaQueryWrapper<Dynamic> wrapper = Wrappers.lambdaQuery();
        wrapper.eq(Dynamic::getUid, 1);
        List<Dynamic> some = dynamicService.list(wrapper); // 第二参数指定为false,使得在查到了多行记录时,不抛出异常,而返回第一条记录
        System.out.println(some);
    }
    @Test
    public void testChain() {
        dynamicService.lambdaUpdate()
                .gt(Dynamic::getMid, 1)
//                .likeRight(Dynamic::getMessage, "再")
                .set(Dynamic::getTime, "2021-05-17 11:05:39")
                .update();
    }

}
