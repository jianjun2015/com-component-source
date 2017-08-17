package component.zk.curator;

import component.zk.curator.create.CreateClient;
import component.zk.curator.create.OperClient;
import component.zk.curator.listener.CuratorWatcher;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.Op;


/**
 * Created by wangjianjun on 2017/7/11.
 */
public class CuratorClientTest {

    private static final String ZK_ADDR= "192.168.66.129:2181,192.168.66.130:2181,192.168.66.131:2181";
    private static final String ZK_PATH="/zktest";

    public static void main(String[] args) {

        CuratorFramework client = null;

        try {
            //创建连接
//            client = CreateClient.createSimple(ZK_ADDR);
            client = CreateClient.createWithOptions(ZK_ADDR,new ExponentialBackoffRetry(1000,3),1000,1000);
            client.start();

            OperClient.createNodeWithRollFunction(client,"/examples/locks", CreateMode.PERSISTENT,"p1_content");
            OperClient.createNodeWithRollFunction(client,"/examples/locks/lock_-1", CreateMode.PERSISTENT,"p1_content1");
            OperClient.createNodeWithRollFunction(client,"/examples/locks/lock_-2", CreateMode.PERSISTENT,"p1_content2");
            OperClient.createNodeWithRollFunction(client,"/examples/locks/lock_-3", CreateMode.PERSISTENT,"p1_content3");
            OperClient.createNodeWithRollFunction(client,"/examples/locks/lock_-4", CreateMode.PERSISTENT,"p1_content4");
            OperClient.createNodeWithRollFunction(client,"/examples/locks/lock_-5", CreateMode.PERSISTENT,"p1_content5");
            OperClient.createNodeWithRollFunction(client,"/examples/locks/lock_-6", CreateMode.PERSISTENT,"p1_content6");
            OperClient.createNodeWithRollFunction(client,"/examples/locks/lock_-7", CreateMode.PERSISTENT,"p1_content7");
            OperClient.createNodeWithRollFunction(client,"/examples/locks/lock_-8", CreateMode.PERSISTENT,"p1_content8");
            OperClient.createNodeWithRollFunction(client,"/examples/locks/lock_-9", CreateMode.PERSISTENT,"p1_content9");
            OperClient.createNodeWithRollFunction(client,"/examples/locks/lock_-10", CreateMode.PERSISTENT,"p1_content10");

//            CuratorWatcher.addWatcherChildrenNode(client,"/super",true);
//            OperClient.createNodeWithRollFunction(client,"/treeCache", CreateMode.PERSISTENT,"p1_content");
//
//            OperClient.createNodeWithRollFunction(client,"/treeCache/s1",CreateMode.PERSISTENT,"s1_content");
//            OperClient.writeData(client,"/treeCache","789");
//            OperClient.writeData(client,"/treeCache/s1","890");
//            OperClient.deleteNode(client,"/treeCache/s1");
//            OperClient.deleteNode(client,"/treeCache");



//            Thread.sleep(1000);
//            OperClient.updateData(client,"/super","upt_data");
//
//            Thread.sleep(1000);
//            OperClient.deleteNode(client,"/super");


                        String value = OperClient.readData(client,"/examples/locks");
//            OperClient.updateData(client,"/kk_p/p1","P1_upot");
//            value = OperClient.readData(client,"/kk_p/p1");
//            System.out.println(value);
//            OperClient.operData(client);
//            OperClient.bindRollFunction(client);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (client != null)
                client.close();
        }
    }
}
