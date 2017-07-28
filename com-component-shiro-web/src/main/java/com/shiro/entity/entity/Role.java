package com.shiro.entity.entity;

import com.shiro.entity.base.VersionEntity;

/**
 * Created by wangjianjun on 2017/5/31.
 */
public class Role extends VersionEntity {

    private String roleName;
    private String description;
    private Boolean superAdmin = false;
    private Boolean available=true;

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setSuperAdmin(Boolean superAdmin) {
        this.superAdmin = superAdmin;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public String getRoleName() {
        return roleName;
    }

    public String getDescription() {
        return description;
    }

    public Boolean getSuperAdmin() {
        return superAdmin;
    }

    public Boolean getAvailable() {
        return available;
    }
}
