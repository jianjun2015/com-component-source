package component.zk.ServiceRegDistr;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;

/**
 * Created by wangjianjun on 2017/8/14.
 */
public class DistributedSystemServer {

    private ZooKeeper zk = null;
    private void getZkClient() throws Exception{
        // 服务器在需求中并不需要做任何监听
        zk = new ZooKeeper(GlobalConstants.ZK_ADDR,GlobalConstants.SESSION_TIMEOUT,null);
    }

    private void connectZK(String serverName,String port) throws Exception{

        //创建父节点
        if (zk.exists(GlobalConstants.PARENT_ZNODE_PATH,false) == null){
            zk.create(GlobalConstants.PARENT_ZNODE_PATH,null,
                    ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        }

        //连接zk创建znode--临时节点，session断开就自动删除
        zk.create(GlobalConstants.PARENT_ZNODE_PATH+"/",
                (serverName+":"+port).getBytes(),
                ZooDefs.Ids.OPEN_ACL_UNSAFE,
                CreateMode.EPHEMERAL_SEQUENTIAL);
        System.out.println("server "+serverName+" is online.....");
    }

    // 服务器的具体业务处理功能
    private void handle(String serverName) throws Exception{
        System.out.println("server "+serverName+" is waiting for task process....");
        Thread.sleep(Long.MAX_VALUE);
    }

    public static void main(String[] args) throws Exception {

        DistributedSystemServer server = new DistributedSystemServer();
        server.getZkClient();

        //一启动就去zk上注册服务，参数1： 服务器的主机名 参数2：服务器的监听端口
        server.connectZK("www.serverNamer.com","9999");

        //进入业务逻辑处理
        server.handle("www.server.com/serverName");
    }
}
