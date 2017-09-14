package three.type.cron4j.schedulingfromfile;

import it.sauronsoftware.cron4j.Scheduler;

import java.io.File;

/**
 * Created by wangjianjun on 2017/9/14.
 */
public class Main {

    public static void main(String[] args) {

        File file = new File(Main.class.getResource("/file/cron4jtab.txt").getFile());
        Scheduler scheduler = new Scheduler();

        scheduler.scheduleFile(file);
        scheduler.start();

        try {
            Thread.sleep(5l*60l*1000l);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        scheduler.stop();
    }
}
