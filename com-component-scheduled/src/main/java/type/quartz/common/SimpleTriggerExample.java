package type.quartz.common;

import org.quartz.*;
import org.quartz.impl.StdScheduler;
import org.quartz.impl.StdSchedulerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by wangjianjun on 2017/9/21.
 */
public class SimpleTriggerExample {

    public static void main(String[] args) throws SchedulerException {

        JobDetail jobDetail = JobBuilder.newJob(HelloJob.class)
                .withIdentity("SimpleJob","group1")
                .build();

        Trigger trigger = TriggerBuilder
                .newTrigger()
                .withIdentity("SimpleTrigger","trgGroup1")
                .withSchedule(
                        SimpleScheduleBuilder.simpleSchedule()
                        .withIntervalInSeconds(5)
                        .repeatForever())
                .build();

        Scheduler scheduler =new StdSchedulerFactory().getScheduler();
        scheduler.start();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd hh:MM:ss");
        System.out.println("now:"+sdf.format(new Date()));
        scheduler.scheduleJob(jobDetail,trigger);
    }
}
