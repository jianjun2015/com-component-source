package second.type;

import java.util.TimerTask;

/**
 * Created by wangjianjun on 2017/8/16.
 */
public class SpringTaskTimer extends TimerTask {
    @Override
    public void run() {
        System.out.println("run task here first...");
    }
}
