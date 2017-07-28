package com.shiro.service.impl;

import com.shiro.dao.TUserLoginInfoMapper;
import com.shiro.dao.TUserMapper;
import com.shiro.entity.module.TUser;
import com.shiro.entity.module.TUserLoginInfo;
import com.shiro.service.UserLoginInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * Created by wangjianjun on 2017/5/31.
 */
@Service
public class UserLoginInfoServiceImpl implements UserLoginInfoService {


    @Autowired
    private TUserLoginInfoMapper userLoginInfoMapper;

    @Autowired
    private TUserMapper userMapper;

    @Transactional(rollbackFor = Exception.class)
    public void recordLoginInfo(String loginName,String token){

        int result = userLoginInfoMapper.insert(buildUserLoginInfo(loginName,token));
        if (result != -1)
            System.out.println("登录记录失败");
    }

    private TUserLoginInfo buildUserLoginInfo(String loginName, String token){

        TUser tUser = userMapper.selectByLoginName(loginName);

        if (tUser == null)
            return null;
        if (token == null)
            token = "token";

        TUserLoginInfo tUserLoginInfo = new TUserLoginInfo();
        tUserLoginInfo.setLoginName(loginName);
        tUserLoginInfo.setUserId(tUser.getId());
        tUserLoginInfo.setToken(token);
        tUserLoginInfo.setCreateTime(new Date());
        tUserLoginInfo.setCreateBy(loginName);
        tUserLoginInfo.setRemark("login");

        return tUserLoginInfo;
    }
}
