package org.seckill.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.module.TSeckill;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created by wangjianjun on 2017/9/16.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TSeckillMapperTest {

    @Resource
    private TSeckillMapper seckillMapper;

    @Test
    public void testReduceNumber()throws Exception{
        int ret = seckillMapper.reduceNumber(1001l,new Date());
        System.out.println(ret);
    }

    @Test
    public void testQueryById()throws Exception{
        TSeckill tSeckill = seckillMapper.selectByPrimaryKey(1001l);
        System.out.println(tSeckill.getName());
    }

    @Test
    public void testQueryAll() throws Exception{
        List<TSeckill> tSeckills = seckillMapper.selectAll();
        System.out.println(tSeckills.size());
    }
}
