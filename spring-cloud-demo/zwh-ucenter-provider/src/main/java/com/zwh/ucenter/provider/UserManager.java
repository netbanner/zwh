package com.zwh.ucenter.provider;

import com.zwh.entity.User;
import com.zwh.mapper.UserMapper;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class UserManager {

    @Resource
    private UserMapper userMapper;

    public User getByUserId(long userId){

        return  userMapper.selectByPrimaryKey(userId);
    }
}
