package type.quartz.listener;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobListener;

/**
 * Created by wangjianjun on 2017/9/21.
 */
public class HelloJobListener implements JobListener{

    public static final String  LISTENER_NAME = "MyJobListenerName";

    @Override
    public String getName() {
        return LISTENER_NAME;
    }

    @Override
    public void jobToBeExecuted(JobExecutionContext context) {
        String jobName = context
                .getJobDetail()
                .getKey()
                .toString();
        System.out.println("jobToBeExecuted");
        System.out.println("Job:"+jobName+" is going to start...");
    }

    /**
     * Job被拒时执行
     * @param context
     */
    @Override
    public void jobExecutionVetoed(JobExecutionContext context) {
        System.out.println("jobExecutionVetoed");
    }

    @Override
    public void jobWasExecuted(JobExecutionContext context, JobExecutionException jobException) {

        System.out.println("jobWasExecuted");
        String jobName = context.getJobDetail().getKey().toString();
        System.out.println("Job : " + jobName + " is finished...");

        if (!jobException.getMessage().equals("")){
            System.out.println("Exception thrown by: " + jobName
                    + " Exception: " + jobException.getMessage());
        }
    }
}
