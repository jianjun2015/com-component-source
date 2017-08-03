package com.base.util.entity;

import java.util.Date;

/**
 * Created by houjun on 2016-5-10.
 */
public class BaseEntity extends Entity implements HasCreateInfo {

    /**
     * 记录创建时间
     */
    private Date createTime;

    /**
     * 创建记录的操作人编号
     */
    private String createBy;

    @Override
    public String getCreateBy() {
        return createBy;
    }

    @Override
    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    @Override
    public Date getCreateTime() {
        return createTime;
    }

    @Override
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
