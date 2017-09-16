package org.seckill.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.module.TSuccessKilled;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by wangjianjun on 2017/9/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TSuccessKilledMapperTest {

    @Resource
    private TSuccessKilledMapper successKilledMapper;

    @Test
    public void testInsertSuccessKilled()throws Exception{

        int ret = successKilledMapper.insertSuccessKilled(1001l,13916801111l);
        System.out.println(ret);
    }

    @Test
    public void testSelectByPrimaryKeyWithSeckill()throws Exception{
        TSuccessKilled tSuccessKilled = successKilledMapper.selectByPrimaryKeyWithSeckill(1001l, 13916801111l);
        System.out.println(tSuccessKilled.getUserPhone());
        System.out.println(tSuccessKilled.getSeckill().getName());
    }


}
