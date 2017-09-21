package type.quartz.listener;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.matchers.KeyMatcher;

/**
 * Created by wangjianjun on 2017/9/21.
 */
public class CronTriggerExample {

    public static void main(String[] args) throws SchedulerException {
        JobKey jobKey = new JobKey("JobNameKey","group1");
        JobDetail jobDetail = JobBuilder.newJob(HelloJob.class)
                .withIdentity(jobKey).build();

        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("trg1","trgG1")
                .withSchedule(CronScheduleBuilder.cronSchedule("*/5 * * * * ?"))
                .build();

        Scheduler scheduler = new StdSchedulerFactory().getScheduler();
        scheduler.getListenerManager().addJobListener(new HelloJobListener(), KeyMatcher.keyEquals(jobKey));
        scheduler.start();
        scheduler.scheduleJob(jobDetail,trigger);
    }
}
