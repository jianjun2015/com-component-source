package component.zk;

import org.apache.zookeeper.*;

import java.io.IOException;

/**
 * 当对目录节点监控状态打开时，一旦目录节点的状态发生变化，Watcher 对象的 process 方法就会被调用。
 * Created by wangjianjun on 2017/8/14.
 */
public class BaseOper {

    private static final String ZK_ADDR= "192.168.66.128:2181,192.168.66.129:2181,192.168.66.130:2181";
    private static final String ZK_PATH="/home/zookeeper/zktest";
    private static final int SESSION_TIMEOUT = 30*1000;

    public static void main(String[] args) throws IOException, KeeperException, InterruptedException {

//        创建一个与服务器的连接
        ZooKeeper zk = new ZooKeeper(ZK_ADDR, SESSION_TIMEOUT, new Watcher() {
            @Override
            public void process(WatchedEvent event) {
//                可以指定对应的事件类型
//                if (event.getType().equals(Event.EventType.NodeCreated))
                System.out.println("已经触发了"+event.getType());
            }
        });

        if (true) {
//        创建一个目录节点
            zk.create("/testRootPath", "testRootPath".getBytes(),
                    ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);

//        创建一个子目录节点
            zk.create("/testRootPath/testChildPathOne", "testChildPathOne".getBytes(),
                    ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);

            System.out.println(new String(zk.getData("/testRootPath/testChildPathOne", false, null)));
            System.out.println(zk.getChildren("/testRootPath", true));

//        设置值
        zk.setData("/testRootPath/testChildPathOne","testChildPathOne_mod".getBytes(),-1);
        System.out.println(zk.exists("/testRootPath",true));

        zk.create("/testRootPath/testChildPathTwo","testChildPathTwo".getBytes(),
                ZooDefs.Ids.OPEN_ACL_UNSAFE,CreateMode.PERSISTENT);
        System.out.println(new String(zk.getData("/testRootPath/testChildPathTwo",true,null)));

        zk.delete("/testRootPath/testChildPathOne",-1);
        zk.delete("/testRootPath/testChildPathTwo",-1);
    }
        zk.delete("/testRootPath",-1);
        zk.close();
    }
}
