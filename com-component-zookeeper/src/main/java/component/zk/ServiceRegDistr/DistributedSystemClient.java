package component.zk.ServiceRegDistr;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangjianjun on 2017/8/14.
 */
public class DistributedSystemClient {

    private volatile List<String> servers = null;
    private ZooKeeper zk = null;

    private void getZkClient() throws Exception{

        zk = new ZooKeeper(GlobalConstants.ZK_ADDR,
                GlobalConstants.SESSION_TIMEOUT,
                new Watcher() {
                    @Override
                    public void process(WatchedEvent event) {
                        if (event.getType().equals(Event.EventType.None)){
                            return;
                        }
                        try {
                            //或取新的服务列表，重新注册监听
                            updateServers();
                        }catch (Exception e){
                            e.printStackTrace();
                        }
                    }
                });
    }

    public void updateServers() throws Exception{
        List<String> children = zk.getChildren(GlobalConstants.PARENT_ZNODE_PATH,true);
        ArrayList<String> serverList = new ArrayList<>();
        for (String child:children){
            byte[] data = zk.getData(GlobalConstants.PARENT_ZNODE_PATH+"/"+child,false,null);
            serverList.add(new String(data));
        }

        servers = serverList;
        for (String server:serverList){
            System.out.println(server);
        }

        System.out.println("######################");
    }

    private void requestService()throws Exception{
//        Thread.sleep(Long.MAX_VALUE);
        System.out.println("success");
    }

    public static void main(String[] args) throws Exception {
        DistributedSystemClient client = new DistributedSystemClient();

        client.getZkClient();

        client.updateServers();

        client.requestService();
    }
}
