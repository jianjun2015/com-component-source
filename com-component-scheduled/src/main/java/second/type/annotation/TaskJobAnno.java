package second.type.annotation;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 注解实现的定时任务
 * Created by wangjianjun on 2017/8/16.
 */
@Component
public class TaskJobAnno {

//    每5秒执行一次
    @Scheduled(cron = "0/5 * * * * ?")
    public void job(){
        System.out.println("TaskJobAnno 执行....");
    }
}
