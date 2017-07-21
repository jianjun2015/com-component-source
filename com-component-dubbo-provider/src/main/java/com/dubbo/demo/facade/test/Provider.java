package com.dubbo.demo.facade.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * Created by wangjianjun on 2017/7/21.
 */
public class Provider {

    public static void main(String[] args) throws IOException {

        ClassPathXmlApplicationContext atx = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-dubbo-provider.xml");

        System.out.println(atx.getDisplayName()+":here");
        atx.start();

        System.out.println("服务启动了");
        System.in.read();
    }
}
