package com.base.util.mybatis;


import com.base.util.entity.BaseEntity;

import java.util.Date;

public class TFinancialWorkingDays extends BaseEntity {

    /**
     *  当前日期,所属表字段为t_ins_fwd.curr_date
     */
    private Date currDate;

    /**
     *  是否为金融工作日,所属表字段为t_ins_fwd.is_fwd
     */
    private Boolean isFwd;

    /**
     * 获取 当前日期 字段:t_ins_fwd.curr_date
     *
     * @return t_ins_fwd.curr_date, 当前日期
     */
    public Date getCurrDate() {
        return currDate;
    }

    /**
     * 设置 当前日期 字段:t_ins_fwd.curr_date
     *
     * @param currDate t_ins_fwd.curr_date, 当前日期
     */
    public void setCurrDate(Date currDate) {
        this.currDate = currDate;
    }

    /**
     * 获取 是否为金融工作日 字段:t_ins_fwd.is_fwd
     *
     * @return t_ins_fwd.is_fwd, 是否为金融工作日
     */
    public Boolean getIsFwd() {
        return isFwd;
    }

    /**
     * 设置 是否为金融工作日 字段:t_ins_fwd.is_fwd
     *
     * @param isFwd t_ins_fwd.is_fwd, 是否为金融工作日
     */
    public void setIsFwd(Boolean isFwd) {
        this.isFwd = isFwd;
    }
}