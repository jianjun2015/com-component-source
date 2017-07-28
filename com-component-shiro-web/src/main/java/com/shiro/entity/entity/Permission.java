package com.shiro.entity.entity;

import com.shiro.entity.base.VersionEntity;

/**
 * Created by wangjianjun on 2017/5/31.
 */
public class Permission extends VersionEntity {

    private String moduleCode;
    private String moduleName;
    private String permCode;
    private String permName;
    private String description;
    private Boolean available;

    public void setModuleCode(String moduleCode) {
        this.moduleCode = moduleCode;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public void setPermCode(String permCode) {
        this.permCode = permCode;
    }

    public void setPermName(String permName) {
        this.permName = permName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public String getModuleCode() {
        return moduleCode;
    }

    public String getModuleName() {
        return moduleName;
    }

    public String getPermCode() {
        return permCode;
    }

    public String getPermName() {
        return permName;
    }

    public String getDescription() {
        return description;
    }

    public Boolean getAvailable() {
        return available;
    }

}
