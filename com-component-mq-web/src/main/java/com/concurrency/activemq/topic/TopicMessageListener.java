package com.concurrency.activemq.topic;

import org.apache.commons.lang.builder.ToStringBuilder;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * Created by wangjianjun on 2017/8/21.
 */

public class TopicMessageListener implements MessageListener {
    @Override
    public void onMessage(Message message) {

        TextMessage tm = (TextMessage) message;
        try {
            System.out.println("---------消息消费---------");
            System.out.println("消息内容:\t" + tm.getText());
            System.out.println("消息ID:\t" + tm.getJMSMessageID());
            System.out.println("消息Destination:\t" + tm.getJMSDestination());
            System.out.println("---------更多信息---------");
            System.out.println(ToStringBuilder.reflectionToString(tm));
            System.out.println("-------------------------");
        } catch (JMSException e) {
            e.printStackTrace();
        }

    }
}
