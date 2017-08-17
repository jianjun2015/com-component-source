package thread.multiply.lock_;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by wangjianjun on 2017/8/17.
 */
public class LockTemplate {

    //加锁模板
    public void addLockTemplate(){

        Lock lock = new ReentrantLock();

        lock.lock();
        try {
            //处理任务
        }catch (Exception e){

        }finally {
            lock.unlock();
        }
    }

    public void addLockTemplate_(){

        Lock lock = new ReentrantLock();

        if (lock.tryLock()) {
            try {
                //处理任务
            } catch (Exception e) {

            } finally {
                lock.unlock();
            }
        }else {
            //未能获取锁，则做其他事情
        }
    }
}
