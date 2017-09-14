package three.type.cron4j.scheduler.listener;

import it.sauronsoftware.cron4j.Scheduler;

/**
 * Created by wangjianjun on 2017/9/14.
 */
public class Main {

    public static void main(String[] args) {
        // Prepares the listener.
        MySchedulerListener listener = new MySchedulerListener();
        // Prepares the task.
        MyTask task = new MyTask();
        // Creates the scheduler.
        Scheduler scheduler = new Scheduler();
        // Registers the listener.
        scheduler.addSchedulerListener(listener);
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
