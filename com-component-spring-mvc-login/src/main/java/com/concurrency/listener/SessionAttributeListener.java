package com.concurrency.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

/**
 * Created by wangjianjun on 2017/9/25.
 */
public class SessionAttributeListener
    implements HttpSessionAttributeListener{

    Logger logger = LoggerFactory.getLogger(ListenerRequestSessionContext.class);

    @Override
    public void attributeAdded(HttpSessionBindingEvent hsbe) {

        HttpSession httpSession=hsbe.getSession();
        logger.info("新建属性："+hsbe.getName()+"值："+hsbe.getValue());
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent hsbe) {
        logger.info("删除属性："+hsbe.getName()+"值："+hsbe.getValue());

    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent hsbe) {
        HttpSession httpSession=hsbe.getSession();

        logger.info("修改属性："+hsbe.getName()+"原值："+hsbe.getValue()+"新值:"+httpSession.getAttribute(hsbe.getName()));

    }
}
