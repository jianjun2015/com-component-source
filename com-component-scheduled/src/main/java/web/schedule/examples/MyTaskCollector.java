package web.schedule.examples;

import it.sauronsoftware.cron4j.SchedulingPattern;
import it.sauronsoftware.cron4j.Task;
import it.sauronsoftware.cron4j.TaskCollector;
import it.sauronsoftware.cron4j.TaskTable;

/**
 * Created by wangjianjun on 2017/9/14.
 */
public class MyTaskCollector implements TaskCollector {

    public TaskTable getTasks() {
        SchedulingPattern pattern = new SchedulingPattern("* * * * *");
        Task task = new MyTask();
        TaskTable ret = new TaskTable();
        ret.add(pattern, task);
        return ret;
    }
}
