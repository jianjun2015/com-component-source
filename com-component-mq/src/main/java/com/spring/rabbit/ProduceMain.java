package com.spring.rabbit;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

/**
 * Created by wangjianjun on 2017/8/15.
 */
public class ProduceMain {

    private static ApplicationContext atx;

    public static void main(String[] args) throws InterruptedException {
        atx = new ClassPathXmlApplicationContext("applicationContext-produce.xml");
        directModel(atx);
    }

    public static void fanoutModel(ApplicationContext atx) throws InterruptedException {
        AmqpTemplate template = (AmqpTemplate) atx.getBean("rabbitTemplate");
        for (int i=0;i<10;i++){
            System.out.println("Sending message#"+i);
            Entity entity = new Entity((long) i,null,"hello world --"+i,new Date());
            template.convertAndSend(entity);
            Thread.sleep(3000);
        }
        System.out.println("Done!!!");
    }

    public static void directModel(ApplicationContext atx){
        AmqpTemplate template = (AmqpTemplate) atx.getBean("rabbitTemplate");
        template.convertAndSend("test_queue_direct_key_1","test_queue_direct_key_1_msg");
        template.convertAndSend("test_queue_direct_key_2","test_queue_direct_key_2_msg");
        template.convertAndSend("test_queue_direct_key_3","test_queue_direct_key_3_msg");
    }
}
