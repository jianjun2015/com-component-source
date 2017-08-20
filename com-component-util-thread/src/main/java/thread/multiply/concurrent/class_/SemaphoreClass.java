package thread.multiply.concurrent.class_;

import java.util.concurrent.Semaphore;

/**
 * 信号量：Semaphore可以控同时访问的线程个数，通过 acquire() 获取一个许可，如果没有就等待，而 release() 释放一个许可。
 * Created by wangjianjun on 2017/8/20.
 */
public class SemaphoreClass {

    public static void main(String[] args) {
        int N = 8;
        Semaphore semaphore = new Semaphore(5);
        for (int i=0;i<N;i++){
            new Worker(i,semaphore).start();
        }
    }

    static class Worker extends Thread{

        private int num;
        private Semaphore semaphore;

        public Worker(int num,Semaphore semaphore){
            this.num = num;
            this.semaphore = semaphore;
        }

        @Override
        public void run() {
            try {
                semaphore.acquire();
                System.out.println("工人："+this.num+"占用一个机器");
                Thread.sleep(2000);
                System.out.println("工人："+this.num+"释放机器");
                semaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
