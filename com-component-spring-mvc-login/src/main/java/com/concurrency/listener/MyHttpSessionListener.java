package com.concurrency.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * 统计在线用户数
 * Created by wangjianjun on 2017/9/25.
 */
@WebListener
public class MyHttpSessionListener implements HttpSessionListener {

    private int userNumber = 0;

    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        userNumber++;
        httpSessionEvent.getSession().getServletContext().setAttribute("userNumber",userNumber);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        userNumber--;
        httpSessionEvent.getSession().getServletContext().setAttribute("userNumber",userNumber);
    }
}
