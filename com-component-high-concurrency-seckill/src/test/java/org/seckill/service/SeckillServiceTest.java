package org.seckill.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.dto.Exposer;
import org.seckill.dto.SeckillExecution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by wangjianjun on 2017/9/18.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class SeckillServiceTest {

    @Autowired
    private SeckillService seckillService;
    private int i = 1003;

    @Test
    public void testExecuteSeckillProcedure(){
        execute();
    }
    @Test
    public void testExecuteSeckillProcedure_(){
        execute();
    }

    public void execute(){
        Exposer exposer = seckillService.exportSeckillUrl(1001l);
        SeckillExecution execution = seckillService.executeSeckillProcedure(1001l, Long.parseLong("1391578"+i++), exposer.getMd5());
        System.out.println(execution.getState());
    }
}
