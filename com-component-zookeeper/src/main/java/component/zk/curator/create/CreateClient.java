package component.zk.curator.create;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;

/**
 * CuratorFramework 创建
 * Created by wangjianjun on 2017/7/12.
 */
public class CreateClient {

    public static CuratorFramework createSimple(String connectionString){
        RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000,3);
        return CuratorFrameworkFactory.newClient(connectionString,retryPolicy);
    }

    public static CuratorFramework createWithOptions(String connectionString,
                                                     RetryPolicy retryPolicy,
                                                     int connectionTimeoutMs,
                                                     int sessionTimeoutMs){
        return CuratorFrameworkFactory.builder()
                .connectString(connectionString)
                .retryPolicy(retryPolicy)
                .connectionTimeoutMs(connectionTimeoutMs)
                .sessionTimeoutMs(sessionTimeoutMs)
                .build();
    }
}
