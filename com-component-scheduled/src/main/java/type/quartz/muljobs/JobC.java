package type.quartz.muljobs;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * Created by wangjianjun on 2017/9/21.
 */
public class JobC implements Job {
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        System.out.println("Job C is running ...");
    }
}
