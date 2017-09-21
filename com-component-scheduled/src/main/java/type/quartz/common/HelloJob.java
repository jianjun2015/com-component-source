package type.quartz.common;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by wangjianjun on 2017/9/21.
 */
public class HelloJob implements Job {
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd hh:MM:ss");
        System.out.print("jobExec:"+sdf.format(new Date()));
        System.out.println("-->Hello Quartz....");
    }
}
