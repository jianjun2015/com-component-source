package type.quartz.muljobs;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

/**
 * Created by wangjianjun on 2017/9/21.
 */
public class CronTriggerExamples {

    public static void main(String[] args) throws SchedulerException {

        JobKey jobKeyA = new JobKey("JobA","grouyp1");
        JobDetail jobDetailA = JobBuilder.newJob(JobA.class)
                .withIdentity(jobKeyA).build();

        JobKey jobKeyB = new JobKey("JobB","grouyp1");
        JobDetail jobDetailB = JobBuilder.newJob(JobB.class)
                .withIdentity(jobKeyB).build();

        JobKey jobKeyC = new JobKey("JobC","grouyp1");
        JobDetail jobDetailC = JobBuilder.newJob(JobC.class)
                .withIdentity(jobKeyC).build();

        Trigger triggerA = TriggerBuilder.newTrigger()
                .withIdentity("tgA","tgG")
                .withSchedule(CronScheduleBuilder.cronSchedule("*/3 * * * * ?"))
                .build();

        Trigger triggerB = TriggerBuilder.newTrigger()
                .withIdentity("tgB","tgG")
                .withSchedule(CronScheduleBuilder.cronSchedule("*/3 * * * * ?"))
                .build();

        Trigger triggerC = TriggerBuilder.newTrigger()
                .withIdentity("tgC","tgG")
                .withSchedule(CronScheduleBuilder.cronSchedule("*/3 * * * * ?"))
                .build();

        Scheduler scheduler = new StdSchedulerFactory().getScheduler();

        scheduler.start();
        scheduler.scheduleJob(jobDetailA,triggerA);
        scheduler.scheduleJob(jobDetailB,triggerB);
        scheduler.scheduleJob(jobDetailC,triggerC);
    }
}
