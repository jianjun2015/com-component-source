package type.quartz.listener;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * Created by wangjianjun on 2017/9/21.
 */
public class HelloJob implements Job {
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        System.out.println("Hello Quartz! - by JJ");
        throw new JobExecutionException("Testing Exception");
    }
}
