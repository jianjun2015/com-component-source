package component.zk;

import org.apache.zookeeper.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Created by wangjianjun on 2017/7/11.
 */
public class ZkClient {

    private static final String ZK_ADDR= "192.168.66.129:2181,192.168.66.130:2181,192.168.66.131:2181";
    private static final String ZK_PATH="/home/zookeeper/zktest";
    private static final int SESSION_TIMEOUT = 30*1000;

    //ZK实例
    private ZooKeeper zk;

    //watch实例
    private Watcher watcher = new Watcher() {
        @Override
        public void process(WatchedEvent watchedEvent) {
            System.out.println("watchedEvent>>>"+watchedEvent.toString());
        }
    };

    private void createZKInstance() throws IOException, InterruptedException {

        zk = new ZooKeeper(ZK_ADDR,SESSION_TIMEOUT,this.watcher);
        if (!zk.getState().equals(ZooKeeper.States.CONNECTED)){
            while (true){
                if (zk.getState().equals(ZooKeeper.States.CONNECTED)){
                    break;
                }
                try {
                    TimeUnit.SECONDS.sleep(5);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    }

    private void ZKOperations() throws KeeperException, InterruptedException {

//        System.out.println("5. 删除节点 ");
//        zk.delete("/zoo2", -1);

        System.out.println("1. 创建 ZooKeeper 节点 (znode ： zoo2, 数据： myData2 ，权限： OPEN_ACL_UNSAFE ，节点类型： Persistent");
        zk.create("/zoo2","myData2".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);

        System.out.println("2. 查看是否创建成功： ");
        System.out.println(new String(zk.getData("/zoo2", this.watcher, null)));// 添加Watch

        // 前面一行我们添加了对/zoo2节点的监视，所以这里对/zoo2进行修改的时候，会触发Watch事件。
        System.out.println("3. 修改节点数据 ");
        zk.setData("/zoo2", "shanhy20160310".getBytes(), -1);

        // 这里再次进行修改，则不会触发Watch事件，这就是我们验证ZK的一个特性“一次性触发”，也就是说设置一次监视，只会对下次操作起一次作用。
        System.out.println("3-1. 再次修改节点数据 ");
        zk.setData("/zoo2", "shanhy20160310-ABCD".getBytes(), -1);

        System.out.println("4. 查看是否修改成功： ");
        System.out.println(new String(zk.getData("/zoo2", false, null)));

//        System.out.println("5. 删除节点 ");
//        zk.delete("/zoo2", -1);

        System.out.println("6. 查看节点是否被删除： ");
        System.out.println(" 节点状态： [" + zk.exists("/zoo2", false) + "]");

    }

    private void ZKClose() throws InterruptedException {
        zk.close();
    }

    public static void main(String[] args) {

        ZkClient zkClient = new ZkClient();
        try {
            zkClient.createZKInstance();
//            System.out.println(zkClient.zk.toString());
            zkClient.ZKOperations();

            zkClient.ZKClose();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (KeeperException e) {
            e.printStackTrace();
        }
    }
}
