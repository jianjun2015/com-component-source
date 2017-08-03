package com.base.util.entity;

import java.util.Date;

/**
 * Created by houjun on 2016-5-10.
 */
public interface HasModifyInfo {

     Date getModifyTime();

     void setModifyTime(Date modifyTime);

    String getModifyBy();

    void setModifyBy(String modifyBy);
}
