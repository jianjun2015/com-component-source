package thread.multiply.threadlocal.example;

/**
 * 这样处理确实也没有任何问题，由于每次都是在方法内部创建的连接，那么线程之间自然不存在线程安全问题。但是这样会有一个致命的
 * 影响：导致服务器压力非常大，并且严重影响程序执行性能。由于在方法中需要频繁地开启和关闭数据库连接，这样不尽严重影响程序执
 * 行效率，还可能导致服务器压力巨大。
 *
 * 那么这种情况下使用ThreadLocal是再适合不过的了，因为ThreadLocal在每个线程中对该变量会创建一个副本，即每个线程内部都会有
 * 一个该变量，且在线程内部任何地方都可以使用，线程之间互不影响，这样一来就不存在线程安全问题，也不会严重影响程序执行性能。
 * 但是要注意，虽然ThreadLocal能够解决上面说的问题，但是由于在每个线程中都创建了副本，所以要考虑它对资源的消耗，比如内存的占
 * 用会比不使用ThreadLocal要大。
 * Created by wangjianjun on 2017/8/18.
 */
public class Dao {

    public void insert(){
        ConnectManager_ manager_ = new ConnectManager_();
        manager_.openConnection();

        //执行操作

        manager_.closeConnection();
    }
}
