package thread.multiply.lock_;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 读写锁
 * Created by wangjianjun on 2017/8/17.
 */
public class ReadWriteLockTest {

    private ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();

    public static void main(String[] args) {
        ReadWriteLockTest test = new ReadWriteLockTest();

        new Thread(){
            @Override
            public void run() {
//                test.get(Thread.currentThread());
                test.get_readLock(Thread.currentThread());
            }
        }.start();

        new Thread(){
            @Override
            public void run() {
//                test.get(Thread.currentThread());
                test.get_readLock(Thread.currentThread());
            }
        }.start();
    }

    public synchronized void get(Thread thread){
        long start = System.currentTimeMillis();
        while (System.currentTimeMillis() - start <= 1){
            System.out.println(thread.getName()+"正在进行读操作...");
        }
        System.out.println(thread.getName()+"读完毕...");
    }

    public void get_readLock(Thread thread){
        rwl.readLock().lock();
        try {
            long start = System.currentTimeMillis();
            while (System.currentTimeMillis() - start <= 1){
                System.out.println(thread.getName()+"正在进行读操作...");
            }
            System.out.println(thread.getName()+"读完毕...");
        }finally {
            rwl.readLock().unlock();
        }

    }
}
