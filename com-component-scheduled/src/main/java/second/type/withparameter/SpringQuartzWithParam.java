package second.type.withparameter;

import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.Map;

/**
 * 可以通过配置文件传入参数的定时任务
 * Created by wangjianjun on 2017/8/16.
 */
public class SpringQuartzWithParam extends QuartzJobBean {
    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {

        JobDataMap jobDataMap = jobExecutionContext.getJobDetail().getJobDataMap();
        for (Map.Entry entry:jobDataMap.entrySet()){
            System.out.println("key --"+entry.getKey()+ " value--:"+entry.getValue());
        }
    }
}
