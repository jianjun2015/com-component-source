package com.shiro.service;

import com.shiro.entity.entity.User;

import java.util.List;

/**
 * Created by wangjianjun on 2017/7/26.
 */
public interface UserService {

    String login(User user);

    User getLoginInfo(User user);

    public void addUser(User user);

    public int updateUser(User user);

    public int deleteUser(User user);

    public User findByLoginName(String loginName);

    public List<User> getAllUsers();

    public List<User> getUsersByIds(List<Long> ids);

    public List<User> getUsersByRoleId(Long roleId);
}
