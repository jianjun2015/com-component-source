package com.shiro.service.impl;

import com.shiro.dao.TUserMapper;
import com.shiro.entity.entity.User;
import com.shiro.entity.module.TUser;
import com.shiro.service.UserService;
import com.shiro.util.PasswordHelper;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by wangjianjun on 2017/7/26.
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private TUserMapper userMapper;

    @Override
    public String login(User user) {

        TUser tUser = new TUser();
        tUser.setLoginName(user.getUserName());
        tUser.setPassword(user.getPassword());

        TUser tUser1 = userMapper.selectByUser(tUser);
        return tUser.getLoginName();
    }

    @Override
    public User getLoginInfo(User user) {
        TUser tUser = new TUser();
        tUser.setLoginName(user.getLoginName());
        tUser.setPassword(user.getPassword());

        TUser tUser_1 = userMapper.selectByUser(tUser);
        return writeUser(tUser_1);
    }

    PasswordHelper helper = new PasswordHelper();

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void addUser(User user) {

        try {
            helper.encrypPassword(user);
            user.setEnabled(Boolean.TRUE);
            userMapper.insert(writeTUser(user));
        } catch (DuplicateKeyException e) {
            System.out.println("请勿重复提交");
        }

    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateUser(User user){
        int count=0;
        try {
            count = userMapper.updateByPrimaryKey(writeTUser(user));
        } catch (DuplicateKeyException e) {
            System.out.println("请勿重复提交");
        }

        return count;
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deleteUser(User user) {

        int count = userMapper.deleteByPrimaryKey(user.getId());
        return count;
    }

    @Override
    public User findByLoginName(String loginName) {

        TUser tUser = userMapper.selectByLoginName(loginName);
        User user = writeUser(tUser);

        return user;
    }

    @Override
    public List<User> getAllUsers() {
        List<TUser> tUsers = userMapper.selectAll();
        List<User> userList = null;

        if (tUsers == null || tUsers.size() == 0)
            return userList;

        userList = new ArrayList<>();
        User user;
        for(TUser tUser:tUsers){
            user = writeUser(tUser);
            userList.add(user);
        }

        return userList;
    }

    @Override
    public List<User> getUsersByIds(List<Long> ids) {
        return null;
    }

    @Override
    public List<User> getUsersByRoleId(Long roleId) {
        List<TUser> tUsers = userMapper.selectByRoleId(roleId);
        List<User> userList = null;
        if (tUsers == null || tUsers.size() == 0){
            return userList;
        }

        User user;
        userList = new ArrayList<>();
        for (TUser tUser:tUsers){
            user = writeUser(tUser);
            userList.add(user);
        }
        return userList;
    }

    private TUser writeTUser(User user){
        TUser tUser = null;

        if (user == null)
            return tUser;

        tUser = new TUser();

        if (user.getId() != null)
            tUser.setId(user.getId());
        tUser.setLoginName(user.getLoginName());
        tUser.setUserName(user.getUserName());
        tUser.setPassword(user.getPassword());
        tUser.setEnabled(user.getEnabled());
        tUser.setSalt(user.getSalt());
        tUser.setEdition(1);
        tUser.setCreateTime(new Date());
        tUser.setCreateBy("sys");
        tUser.setModifyTime(new Date());
        tUser.setModifyBy("sys");

        return tUser;
    }

    private User writeUser(TUser tUser){
        User user = null;

        if (tUser == null)
            return user;

        user = new User();

        user.setId(tUser.getId());
        user.setLoginName(tUser.getLoginName());
        user.setUserName(tUser.getUserName());
        user.setPassword(tUser.getPassword());
        user.setSalt(tUser.getSalt());
        user.setEnabled(tUser.getEnabled());
        user.setCreateTime(tUser.getCreateTime());
        user.setCreateBy(tUser.getCreateBy());
        user.setModifyTime(tUser.getModifyTime());
        user.setModifyBy(tUser.getModifyBy());

        return user;
    }
}
