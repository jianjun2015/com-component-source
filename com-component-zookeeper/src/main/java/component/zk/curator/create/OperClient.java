package component.zk.curator.create;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.api.BackgroundCallback;
import org.apache.curator.framework.api.CuratorEvent;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.data.Stat;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by wangjianjun on 2017/7/12.
 */
public class OperClient {

    /**
     * 1.CreateMode.PERSISTENT: 创建节点后，不删除就永久存在
     2.CreateMode.PERSISTENT_SEQUENTIAL：节点path末尾会追加一个10位数的单调递增的序列
     3.CreateMode.EPHEMERAL：创建后，回话结束节点会自动删除
     4.CreateMode.EPHEMERAL_SEQUENTIAL：节点path末尾会追加一个10位数的单调递增的序列
     * @param client
     * @param path
     * @param data
     * @return
     */
    public static void createNode(CuratorFramework client, String path, CreateMode createMode, String data) {
        try {
            client.create().creatingParentsIfNeeded().withMode(createMode).forPath(path, data.getBytes());
        } catch (Exception e) {
            System.out.println("创建节点失败, elog=" + e.getMessage());
        }
    }

    public static void createNodeWithRollFunction(CuratorFramework client, String path, CreateMode createMode, String data) {
        ExecutorService pool = Executors.newCachedThreadPool();
        try {
            client.create().creatingParentsIfNeeded().withMode(createMode)
                    .inBackground(new BackgroundCallback() {
                        @Override
                        public void processResult(CuratorFramework client, CuratorEvent event) throws Exception {
                            System.out.println("code:"+event.getResultCode());
                            System.out.println("type:"+event.getType());
                            System.out.println("线程:"+Thread.currentThread().getName());
                        }
                    },pool).forPath(path,data.getBytes());
        } catch (Exception e) {
            System.out.println("创建节点失败, elog=" + e.getMessage());
        }
    }

    public static String readData(CuratorFramework client,String path){

        try {
            return new String(client.getData().forPath(path));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public static void writeData(CuratorFramework client,String path,String data){

        try {
            client.setData().forPath(path,data.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void updateData(CuratorFramework client,String path,String data){

        try {
            client.setData().forPath(path, data.getBytes());
        } catch (Exception e) {
            System.out.println("更新节点数据失败, elog=" + e.getMessage());
        }
    }

    /**
     * 删除节点
     * @param client
     * @param path
     */
    public static void deleteNode(CuratorFramework client, String path) {
        try {
            client.delete().guaranteed().deletingChildrenIfNeeded().forPath(path);
        } catch (Exception e) {
            System.out.println("删除节点失败, elog=" + e.getMessage());
        }
    }

    public static void operData(CuratorFramework client){

        //TODO 创建节点路径有问题-创建不成功，如果之前创建好了路径，则可以正常操作
        try {
//            client.create().creatingParentsIfNeeded().withMode(CreateMode.PERSISTENT).forPath("/super","zoo3内容".getBytes());
//            client.create().creatingParentsIfNeeded().withMode(CreateMode.PERSISTENT).forPath("/super/c2","c2内容".getBytes());
//            client.create().forPath("/aaa");
            client.create().creatingParentsIfNeeded().forPath("/kk/k1","KK__CONTENT".getBytes());

            client.setData().forPath("/zoo2","zhangsan".getBytes());
            System.out.println(new String(client.getData().forPath("/zoo2")));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 绑定回掉函数
     * @param client
     */
    public static void bindRollFunction(CuratorFramework client){

        ExecutorService pool = Executors.newCachedThreadPool();
        try {
            client.create().creatingParentsIfNeeded().withMode(CreateMode.PERSISTENT)
                    .inBackground(new BackgroundCallback() {
                        @Override
                        public void processResult(CuratorFramework client, CuratorEvent event) throws Exception {
                            System.out.println("code:"+event.getResultCode());
                            System.out.println("type:"+event.getType());
                            System.out.println("线程:"+Thread.currentThread().getName());
                        }
                    },pool).forPath("/super/c1","c内容".getBytes());
            Thread.sleep(1000);

            List<String> list = client.getChildren().forPath("/super");
            for (String s:list){
                System.out.println(s);
            }

            Stat stat = client.checkExists().forPath("/super");
            System.out.println(stat);

            Thread.sleep(1000);
            client.delete().guaranteed().deletingChildrenIfNeeded().forPath("/super");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
