package thread.multiply.thread.pool;

import java.util.concurrent.*;

/**
 * Created by wangjianjun on 2017/8/20.
 */
public class ThreadPoolExecutorClass {

    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5,10,200,
                TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<Runnable>(5));

        //i>15抛异常--拒绝
        for (int i=0;i<15;i++){
            MyTask task = new MyTask(i);
            executor.execute(task);
            System.out.println("线程池线程数量："+executor.getPoolSize()+
                    ",队列中等待执行的数量："+executor.getQueue().size()+
                    ",已执行完的任务数量："+executor.getCompletedTaskCount());
        }
    }
}

class MyTask implements Runnable{
    private int taskNum;

    public MyTask(int taskNum) {
        this.taskNum = taskNum;
    }

    @Override
    public void run() {
        System.out.println("正在执行task："+taskNum);
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("执行完毕："+taskNum);
    }
}
