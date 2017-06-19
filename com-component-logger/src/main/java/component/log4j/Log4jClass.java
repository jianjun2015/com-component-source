package component.log4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by wangjianjun on 2017/6/19.
 */
public class Log4jClass {

    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(Log4jClass.class);
        logger.debug("this is a debug msg");

        // 占位符
        logger.debug("hi，welcome {}，today is {}","admin","Sunday");
    }
}
