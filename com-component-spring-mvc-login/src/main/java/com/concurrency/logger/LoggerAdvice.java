package com.concurrency.logger;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * Created by wangjianjun on 2017/9/25.
 */
@Aspect
@Component
public class LoggerAdvice {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Before("within(com.concurrency.controller..*) && @annotation(loggerManage)")
    public void addBeforeLogger(JoinPoint joinPoint,LoggerManage loggerManage){
        logger.info("执行:"+loggerManage.description()+" 开始");
        logger.info(joinPoint.getSignature().toString());
        logger.info(parseParames(joinPoint.getArgs()));
    }

    @AfterReturning("within(com.concurrency.controller..*) && @annotation(loggerManage)")
    public void addAfterReturningLogger(JoinPoint joinPoint,LoggerManage loggerManage){
        logger.info("执行:"+loggerManage.description()+" 结束");
    }

    @AfterThrowing("within(com.concurrency.controller..*) && @annotation(loggerManage)")
    public void addAfterThrowingLogger(JoinPoint joinPoint,LoggerManage loggerManage){
        logger.error("执行:"+loggerManage.description()+ " 异常");
    }

    private String parseParames(Object[] parames) {
        if (null == parames || parames.length <= 0) {
            return "";
        }
        StringBuffer param = new StringBuffer("传入参数[{}] ");
        for (Object obj : parames) {
            param.append(ToStringBuilder.reflectionToString(obj)).append("  ");
        }
        return param.toString();
    }
}
