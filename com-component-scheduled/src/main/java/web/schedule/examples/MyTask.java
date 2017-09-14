package web.schedule.examples;

import it.sauronsoftware.cron4j.Task;
import it.sauronsoftware.cron4j.TaskExecutionContext;

/**
 * Created by wangjianjun on 2017/9/14.
 */
public class MyTask extends Task {

    public boolean canBePaused() {
        return true;
    }

    public boolean canBeStopped() {
        return true;
    }

    public boolean supportsCompletenessTracking() {
        return true;
    }

    public boolean supportsStatusTracking() {
        return true;
    }

    @Override
    public void execute(TaskExecutionContext executor) throws RuntimeException {
        for (int i = 1; i <= 30; i++) {
            System.out.println("Task says   : " + i);
            executor.setStatusMessage("i = " + i);
            executor.setCompleteness(i / 30D);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                ;
            }
            executor.pauseIfRequested();
            if (executor.isStopped()) {
                break;
            }
        }
    }
}
