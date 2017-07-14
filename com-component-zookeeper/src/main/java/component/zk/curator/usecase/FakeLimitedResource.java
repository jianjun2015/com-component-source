package component.zk.curator.usecase;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * 模拟公共资源-期望只能单线程访问，避免并发问题
 * Created by wangjianjun on 2017/7/12.
 */
public class FakeLimitedResource {

    private final AtomicBoolean inUse = new AtomicBoolean(false);

    public void use() throws InterruptedException {

        //例子在使用锁的情况下不会抛出非法并发异常 IllegalStateException
        //但是在无锁的情况下，由于sleep了一段时间，所以很容易抛出异常
        if (!inUse.compareAndSet(false,true)){
            throw new IllegalStateException("Needs to be used by one client at a time");
        }

        try {
            Thread.sleep((long) (3*Math.random()));
        }finally {
            inUse.set(false);
        }
    }
}
