package com.concurrency.service.impl;

import com.concurrency.dao.TUserMapper;
import com.concurrency.entity.User;
import com.concurrency.module.TUser;
import com.concurrency.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by wangjianjun on 2017/7/7.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private TUserMapper userMapper;

    @Override
    public void insertUser(User user) {

        userMapper.insert(writeTUser(user));
    }

    @Override
    public User getUserByName(Integer uId) {
        return writeUser(userMapper.selectByPrimaryKey(uId));
    }

    private TUser writeTUser(User user){

        TUser tUser = new TUser();
        tUser.setUserId(user.getUserId());
        tUser.setUserAge(user.getUserAge());
        tUser.setUserName(user.getUserName());
        tUser.setUserBirthday(user.getUserBirthday());
        tUser.setUserSalary(user.getUserSalary());

        return tUser;
    }

    private User writeUser(TUser tUser){

        User user = new User();
        user.setUserId(tUser.getUserId());
        user.setUserName(tUser.getUserName());
        user.setUserAge(tUser.getUserAge());
        user.setUserBirthday(tUser.getUserBirthday());
        user.setUserSalary(tUser.getUserSalary());

        return user;
    }
}
