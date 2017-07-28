package com.shiro.entity.entity;

import com.shiro.entity.base.BaseEntity;

/**
 * Created by wangjianjun on 2017/5/31.
 */
public class UserLoginInfo extends BaseEntity {

    private Long userId;
    private String loginName;
    private String token;
    private String remark;

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Long getUserId() {
        return userId;
    }

    public String getLoginName() {
        return loginName;
    }

    public String getToken() {
        return token;
    }

    public String getRemark() {
        return remark;
    }
}
