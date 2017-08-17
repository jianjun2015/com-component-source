package component.zk.curator.usecase;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;

import java.util.concurrent.TimeUnit;

/**
 * Created by wangjianjun on 2017/7/12.
 */
public class ExampleClientThatLocks {

    private final InterProcessMutex lock;
    private final FakeLimitedResource resource;
    private final String clientName;

    //这种写法注意，final 修饰的可以不初始化
    public ExampleClientThatLocks(CuratorFramework client,String path,FakeLimitedResource resource,String clientName){

        this.lock = new InterProcessMutex(client,path);
        this.resource = resource;
        this.clientName=clientName;
    }

    public void doWork(long time, TimeUnit  timeUnit) throws Exception {
        if (!lock.acquire(time,timeUnit)){
            throw new IllegalStateException(clientName+" could not acquire the lock_");
        }

        System.out.println(clientName + " has the lock_");

        try {
            resource.use();
        }finally {
            System.out.println(clientName + " release the lock_");
            lock.release();
        }

    }
}
