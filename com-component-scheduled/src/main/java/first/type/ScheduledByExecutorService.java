package first.type;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 用ScheduledExecutorService是从的java.util.concurrent里，做为并发工具类被引进的，这是最理想的定时任务实现方式:
 * 相比于Timer的单线程，它是通过线程池的方式来执行任务的
 * 可以很灵活的去设定第一次执行任务delay时间
 * 提供了良好的约定，以便设定执行的时间间隔
 * Created by wangjianjun on 2017/8/16.
 */
public class ScheduledByExecutorService {

    public static void main(String[] args) {

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello third qa !!!");
            }
        };

        ScheduledExecutorService service =Executors.newSingleThreadScheduledExecutor();
        service.scheduleAtFixedRate(runnable,0,3, TimeUnit.SECONDS);
    }
}
