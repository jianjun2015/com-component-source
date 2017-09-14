package three.type.cron4j.quickstart;

import java.util.Date;

/**
 * Created by wangjianjun on 2017/9/14.
 */
public class MyTask implements Runnable{
    @Override
    public void run() {
        System.out.println("Current system time: " + new Date());
        System.out.println("Another minute ticked away...");
    }
}
