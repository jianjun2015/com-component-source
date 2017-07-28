package com.shiro.entity.base;

import java.util.Date;

/**
 * Created by houjun on 2016-5-10.
 */
public interface HasCreateInfo {

    Date getCreateTime();

    void setCreateTime(Date createTime);

    String getCreateBy();

    void setCreateBy(String createBy);
}
