package com.tuling.teach.service;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ZkProvider {
    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
               "config/spring-dubbo-zk-provider.xml");
        context.start();
        System.out.println("dubbo 服务启动成功 ");
        System.in.read(); // press any key to exit
    }
}