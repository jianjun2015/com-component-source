package com.dubbo.demo.facade;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by wangjianjun on 2017/7/21.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext-root.xml"})
public class ConsumeTest {

    @Resource
    private DemoService demoService;

    public static void main(String[] args) {
        ClassPathXmlApplicationContext atx = new ClassPathXmlApplicationContext("classpath:applicationContext-root.xml");
        atx.start();

        DemoService demoService = (DemoService) atx.getBean("demoService");

        demoService.showMsg("HAHAHA");


    }

    @Test
    public void testT(){

        System.out.println(demoService.showMsg("XX"));
    }


}
