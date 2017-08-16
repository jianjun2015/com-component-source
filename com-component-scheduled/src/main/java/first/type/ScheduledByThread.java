package first.type;

/**
 * 通过线程来实现--定时间隔执行
 * Created by wangjianjun on 2017/8/16.
 */
public class ScheduledByThread {

    public static void main(String[] args) {

        final long timeInterval = 3000;
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                while (true) {
                    System.out.println("Hello qa !!! ");
                    try {
                        Thread.sleep(timeInterval);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        Thread thread = new Thread(runnable);
        thread.start();
    }
}
