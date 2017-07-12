package component.zk;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.curator.retry.RetryNTimes;
import org.apache.zookeeper.*;

import java.io.IOException;

/**
 * Created by wangjianjun on 2017/7/11.
 */
public class CuratorClientTest {

    private static final String ZK_ADDR= "192.168.66.129:2181,192.168.66.130:2181,192.168.66.131:2181";
    private static final String ZK_PATH="/zktest";

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

    public static void main(String[] args) {

        CuratorFramework client = null;

        try {
            client = createSimple(ZK_ADDR);
            client.start();
            client.create().creatingParentsIfNeeded().forPath(ZK_PATH,"test".getBytes());

//            client = createWithOptions(ZK_ADDR,new ExponentialBackoffRetry(1000,3),1000,1000);
//            client.start();

            System.out.println(new String(client.getData().forPath(ZK_PATH)));
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (client != null)
                client.close();
        }
    }
}
