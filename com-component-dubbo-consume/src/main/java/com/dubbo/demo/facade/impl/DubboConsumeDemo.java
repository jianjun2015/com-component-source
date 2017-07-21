package com.dubbo.demo.facade.impl;

import com.dubbo.demo.facade.DemoService;
import org.junit.Test;

import javax.annotation.Resource;
import javax.inject.Named;
import java.util.List;

/**
 * Created by wangjianjun on 2017/7/20.
 */
//@Named
public class DubboConsumeDemo extends BaseTest{

    @Resource
    private DemoService demoService;

    @Test
    public void test() {
        System.out.println(demoService.showMsg("Hello Dubbox"));
        List<String> list = demoService.getPermissions(1l);
        System.out.println(list.size());

        try {
            //使线程休眠一段时间，以便于在dubbo-admin上显示消费的情况
            Thread.sleep(100000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
