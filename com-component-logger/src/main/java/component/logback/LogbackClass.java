package component.logback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by wangjianjun on 2017/6/19.
 */
public class LogbackClass {

    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(LogbackClass.class);
        logger.debug("this is a debug msg");

        // 占位符
        logger.debug("hi，welcome {}，today is {}","admin","Sunday");
    }
}
