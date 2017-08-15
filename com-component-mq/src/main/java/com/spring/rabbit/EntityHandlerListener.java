package com.spring.rabbit;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;

import java.io.UnsupportedEncodingException;

/**
 * 消息监听，可以对接收的消息进行逻辑处理
 * Created by wangjianjun on 2017/8/15.
 */
public class EntityHandlerListener implements MessageListener {

    @Override
    public void onMessage(Message message) {
        try {
            String body = new String(message.getBody(),"UTF-8");
            System.out.println(body);

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
