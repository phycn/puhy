package cn.puhy.study.shardingjdbc.springboot.controller;

import cn.puhy.study.shardingjdbc.springboot.dao.mapper.UserMapper;
import cn.puhy.study.shardingjdbc.springboot.dao.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/get/{id}")
    public User getUser(@PathVariable("id") int id) {
        System.out.println(id);
        return userMapper.queryById(id);
    }

    @GetMapping("/mobile/{mobile}")
    public User getUserByMobile(@PathVariable("mobile") String mobile) {
        System.out.println(mobile);
        return userMapper.queryByMobile(mobile);
    }
}
