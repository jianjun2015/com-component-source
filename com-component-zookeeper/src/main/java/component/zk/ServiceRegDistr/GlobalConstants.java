package component.zk.ServiceRegDistr;

/**
 * Created by wangjianjun on 2017/8/14.
 */
public class GlobalConstants {

    public static final String ZK_ADDR= "192.168.66.128:2181,192.168.66.129:2181,192.168.66.130:2181";
    public static final String ZK_PATH="/home/zookeeper/zktest";
    public static final int SESSION_TIMEOUT = 30*1000;
    // 服务在zk下的路径
    public static final String PARENT_ZNODE_PATH = "/servers";
}
