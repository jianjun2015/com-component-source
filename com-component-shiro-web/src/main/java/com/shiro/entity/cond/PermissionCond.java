package com.shiro.entity.cond;

/**
 * Created by wangjianjun on 2017/6/9.
 */
public class PermissionCond {

    private String moduleCode;
    private String moduleName;
    private String permCode;
    private String permName;

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
}
