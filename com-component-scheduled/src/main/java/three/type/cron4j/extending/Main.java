package three.type.cron4j.extending;

import it.sauronsoftware.cron4j.Scheduler;

/**
 * Created by wangjianjun on 2017/9/14.
 */
public class Main {

    public static void main(String[] args) {
        MyTask task = new MyTask();
        // Creates the scheduler.
        Scheduler scheduler = new Scheduler();
        // Schedules the task, once every minute.
        scheduler.schedule("* * * * *", task);
        // Starts the scheduler.
        scheduler.start();
        // Stays alive for five minutes.
        try {
            Thread.sleep(5L * 60L * 1000L);
        } catch (InterruptedException e) {
            ;
        }
        // Stops the scheduler.
        scheduler.stop();
    }
}
