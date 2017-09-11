package com.concurrency.service;

import com.concurrency.entity.User;

/**
 * Created by wangjianjun on 2017/7/7.
 */
public interface UserService {

    void insertUser(User user);

    User getUserByName(Integer uId);
}
