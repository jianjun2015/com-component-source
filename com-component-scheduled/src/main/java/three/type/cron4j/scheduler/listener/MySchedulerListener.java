package three.type.cron4j.scheduler.listener;

import it.sauronsoftware.cron4j.SchedulerListener;
import it.sauronsoftware.cron4j.TaskExecutor;

/**
 * Created by wangjianjun on 2017/9/14.
 */
public class MySchedulerListener implements SchedulerListener {

    public void taskLaunching(TaskExecutor executor) {
        System.out.println("Task launched!");
    }

    public void taskSucceeded(TaskExecutor executor) {
        System.out.println("Task completed!");
    }

    public void taskFailed(TaskExecutor executor, Throwable exception) {
        System.out.println("Task failed due to an exception!");
        exception.printStackTrace();
    }

}
