package com.spring.rabbit;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by wangjianjun on 2017/8/15.
 */
public class ConsumeMain_1 {

    static ApplicationContext atx = null;

    public static void main(String[] args) {
        atx = new ClassPathXmlApplicationContext("applicationContext-consume.xml");
    }
}
