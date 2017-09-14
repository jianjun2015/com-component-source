package component.scheduler.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by wangjianjun on 2017/8/21.
 */
@Component
public class SchedulerTask {

    private int count=0;

    @Scheduled(cron="*/6 * * * * ?")//6秒执行一次
    private void process(){
        System.out.println("this is scheduler task runing  "+(count++)+" "+new Date());
    }

}