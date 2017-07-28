package com.shiro.entity.entity;


import com.shiro.entity.base.VersionEntity;

/**
 * Created by wangjianjun on 2017/5/31.
 */
public class User extends VersionEntity {

    private String userName;
    private String loginName;
    private String password="password";
    private String salt="salt";
    private Boolean enabled=true;

    public String getCredentialsSalt() {
        return loginName + salt;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public String getUserName() {
        return userName;
    }

    public String getLoginName() {
        return loginName;
    }

    public String getPassword() {
        return password;
    }

    public String getSalt() {
        return salt;
    }

    public Boolean getEnabled() {
        return enabled;
    }
}
