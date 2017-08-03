package com.base.util.entity;

import java.util.Date;

/**
 * Created by houjun on 2016-5-10.
 */
public class StandardEntity extends BaseEntity implements HasModifyInfo {

    /**
     * 记录修改时间
     */
    private Date modifyTime;

    /**
     * 修改记录的操作人编号
     */
    private String modifyBy;

    @Override
    public String getModifyBy() {
        return modifyBy;
    }

    @Override
    public void setModifyBy(String modifyBy) {
        this.modifyBy = modifyBy;
    }

    @Override
    public Date getModifyTime() {
        return modifyTime;
    }

    @Override
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }
}
