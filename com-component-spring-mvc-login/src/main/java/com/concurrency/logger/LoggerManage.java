package com.concurrency.logger;

import java.lang.annotation.*;

/**
 * Created by wangjianjun on 2017/9/25.
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LoggerManage {

    String description();
}
