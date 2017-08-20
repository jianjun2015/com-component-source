package thread.multiply.communication;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by wangjianjun on 2017/8/20.
 */
public class ConditionClass {

    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        Condition condition = lock.newCondition();

        /**
         * Conditon中的await()对应Object的wait()；
         * Condition中的signal()对应Object的notify()；
         * Condition中的signalAll()对应Object的notifyAll()。
         */
    }
}
