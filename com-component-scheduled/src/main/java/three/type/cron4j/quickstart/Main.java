package three.type.cron4j.quickstart;

import it.sauronsoftware.cron4j.Scheduler;

/**
 * Created by wangjianjun on 2017/9/14.
 */
public class Main {

    public static void main(String[] args) {

        MyTask task = new MyTask();
        Scheduler scheduler = new Scheduler();

        //MINUTE HOUR DAY_OF_MONTH MONTH DAY_OF_WEEK  --最小粒度是分钟
        scheduler.schedule("* * * * *",task);
        scheduler.start();

        try {
            Thread.sleep(3l*60l*1000l);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        scheduler.stop();
    }
}
