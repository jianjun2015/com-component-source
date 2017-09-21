package type.quartz.common;

import org.quartz.*;
import org.quartz.impl.StdScheduler;
import org.quartz.impl.StdSchedulerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by wangjianjun on 2017/9/21.
 */
public class CronTriggerExample {

    public static void main(String[] args) throws SchedulerException {

        JobDetail jobDetail = JobBuilder.newJob(HelloJob.class)
                .withIdentity("cronJob","group2")
                .build();

        //cron:秒 分钟 小时 天 月 星期 年
        Trigger trigger = TriggerBuilder
                .newTrigger()
                .withIdentity("trigger1","trgGroup2")
                .withSchedule(CronScheduleBuilder
                    .cronSchedule("*/5 * * * * ?"))
                .build();

        Scheduler scheduler = new StdSchedulerFactory().getScheduler();
        scheduler.start();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd hh:MM:ss");
        System.out.println("cron now:"+sdf.format(new Date()));
        scheduler.scheduleJob(jobDetail,trigger);
    }
}
