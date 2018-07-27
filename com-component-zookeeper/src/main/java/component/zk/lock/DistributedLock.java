package component.zk.lock;

import java.util.concurrent.TimeUnit;

/**
 * @author: wangjianjun
 * @description:
 * @date: 2018/5/9 16:07
 * @version: V1.0
 */
public interface DistributedLock {

    public void  qcqurie() throws Exception;

    public void acqurire(long time, TimeUnit unit) throws Exception;

    public void release() throws Exception;
}
