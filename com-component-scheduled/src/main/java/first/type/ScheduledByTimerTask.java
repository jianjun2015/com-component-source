package first.type;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 通过Timer和TimerTask来实现
 * 可以指定什么时候执行，及延迟多长时间执行
 * Created by wangjianjun on 2017/8/16.
 */
public class ScheduledByTimerTask {

    public static void main(String[] args) throws ParseException {

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                System.out.println("hello second qa !!!");
            }
        };

        Timer timer = new Timer();
        long deley = 0;
        long intevalPeriod = 1*1000;
//        timer.scheduleAtFixedRate(task,deley,intevalPeriod);

        Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2017-08-16 17:09:00");
        timer.schedule(task,date);
    }
}
