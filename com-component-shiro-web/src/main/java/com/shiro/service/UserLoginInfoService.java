package com.shiro.service;

/**
 * Created by wangjianjun on 2017/5/31.
 */
public interface UserLoginInfoService {

    public void recordLoginInfo(String loginName, String token);
}
