package com.concurrency.filter;

import javax.servlet.*;
import java.io.IOException;
import java.util.Enumeration;

/**
 * Created by wangjianjun on 2017/9/22.
 */
public class MyFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("init ---------");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        // 对request、response进行一些预处理
        servletRequest.setCharacterEncoding("UTF-8");
        servletResponse.setCharacterEncoding("UTF-8");
        servletResponse.setContentType("text/html;charset=UTF-8");
        System.out.println("----调用service之前执行一段代码----");

        String parameterName = null;
        String parameterValue = null;
        Enumeration<String> allParameter = servletRequest.getParameterNames();
        while(allParameter.hasMoreElements()) {
            parameterName = allParameter.nextElement();
            parameterValue = servletRequest.getParameter(parameterName);
            System.out.println(parameterName+":"+parameterValue);
        }

        filterChain.doFilter(servletRequest, servletResponse); // 执行目标资源，放行
        System.out.println("----调用service之后执行一段代码----");
    }

    @Override
    public void destroy() {
        System.out.println("destroy ----");
    }
}
