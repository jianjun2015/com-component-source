package com.shiro.entity.entity;

import com.shiro.entity.base.BaseEntity;

/**
 * Created by wangjianjun on 2017/5/31.
 */
public class RolePermission extends BaseEntity {

    private Long roleId;
    private Long permissionId;

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public void setPermissionId(Long permissionId) {
        this.permissionId = permissionId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public Long getPermissionId() {
        return permissionId;
    }
}
