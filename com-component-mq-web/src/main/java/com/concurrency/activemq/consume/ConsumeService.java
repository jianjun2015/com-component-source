package com.concurrency.activemq.consume;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.TextMessage;

/**
 * Created by wangjianjun on 2017/8/21.
 */
@Service
public class ConsumeService {

    @Resource(name = "jmsTemplate")
    private JmsTemplate jmsTemplate;

    public TextMessage receive(Destination destination){
        TextMessage tm = (TextMessage) jmsTemplate.receive(destination);
        try {
            System.out.println("队列"+destination.toString()+
            "收到了消息:"+tm.getText());
        } catch (JMSException e) {
            e.printStackTrace();
        }

        return tm;
    }
}
