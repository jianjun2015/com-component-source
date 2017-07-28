package com.shiro.entity.entity;


import com.shiro.entity.base.BaseEntity;

/**
 * Created by wangjianjun on 2017/5/31.
 */
public class UserRole extends BaseEntity {

    private Long userId;
    private Long roleId;

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getUserId() {
        return userId;
    }

    public Long getRoleId() {
        return roleId;
    }
}
