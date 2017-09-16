package org.seckill.entitiy;

import org.seckill.module.TSuccessKilled;

/**
 * Created by wangjianjun on 2017/9/15.
 */
public class SuccessKilled extends TSuccessKilled {

    @Override
    public String toString() {
        return "SuccessKilled{" +
                "seckillId=" + seckillId +
                ", userPhone=" + userPhone +
                ", state=" + state +
                ", createTime=" + createTime +
                '}';
    }
}
