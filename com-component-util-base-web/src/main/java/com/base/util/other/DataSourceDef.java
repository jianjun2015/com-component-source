package com.base.util.other;

import com.base.util.entity.StandardEntity;

/**
 *数据源定义
 * Created by houjun on 2016-12-6.
 */
public class DataSourceDef extends StandardEntity {

    /**
     * 数据库类型：默认mysql
     */
    private DatabaseType dsType = DatabaseType.mysql;
    /**
     * 数据源名称，唯一
     */
    private String dsName;
    /**
     * jdbc连接地址
     */
    private String jdbcUrl;
    /**
     * 数据库用户名
     */
    private String dsUserName;
    /**
     * 数据库密码
     */
    private String dsPassword;

    public String getDsName() {
        return dsName;
    }

    public void setDsName(String dsName) {
        this.dsName = dsName;
    }

    public String getDsPassword() {
        return dsPassword;
    }

    public void setDsPassword(String dsPassword) {
        this.dsPassword = dsPassword;
    }

    public DatabaseType getDsType() {
        return dsType;
    }

    public void setDsType(DatabaseType dsType) {
        this.dsType = dsType;
    }

    public String getDsUserName() {
        return dsUserName;
    }

    public void setDsUserName(String dsUserName) {
        this.dsUserName = dsUserName;
    }

    public String getJdbcUrl() {
        return jdbcUrl;
    }

    public void setJdbcUrl(String jdbcUrl) {
        this.jdbcUrl = jdbcUrl;
    }
}
