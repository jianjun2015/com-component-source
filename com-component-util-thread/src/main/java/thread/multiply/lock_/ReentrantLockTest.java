package thread.multiply.lock_;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 可重入锁
 * Created by wangjianjun on 2017/8/17.
 */
public class ReentrantLockTest {

    private List<Integer> list = new ArrayList<>();
    private Lock lock = new ReentrantLock();//定义在类中

    public static void main(String[] args) {

        ReentrantLockTest test = new ReentrantLockTest();
        new Thread(){
            @Override
            public void run() {
                test.insert_(Thread.currentThread());
            }
        }.start();

        new Thread(){
            @Override
            public void run() {
                test.insert_(Thread.currentThread());
            }
        }.start();

    }

    public void insert(Thread thread){
        lock.lock();
        try {
            System.out.println(thread.getName()+"得到了锁");
            for (int i=0;i<5;i++)
                list.add(i);
        }catch (Exception e){

        }finally {
            System.out.println(thread.getName()+"释放了锁");
            lock.unlock();
        }
    }

    public void insert_(Thread thread){
        if (lock.tryLock()){
            try {
                System.out.println(thread.getName()+"得到了锁.");
                Thread.sleep(10000);
                for (int i=0;i<5;i++)
                    list.add(i);
            }catch (Exception e){

            }finally {
                System.out.println(thread.getName()+"释放了锁");
                lock.unlock();
            }
        }else {
            System.out.println(thread+"没有得到锁....");
        }
    }
}
