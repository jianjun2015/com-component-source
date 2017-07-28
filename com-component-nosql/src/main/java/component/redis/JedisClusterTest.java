package component.redis;

import org.junit.Before;
import org.junit.Test;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPoolConfig;

import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created by wangjianjun on 2017/7/28.
 */
public class JedisClusterTest {

    @Before
    public void setup(){

    }

    @Test
    public void testCluster(){

        JedisPoolConfig poolConfig = new JedisPoolConfig();
        // 最大连接数
        poolConfig.setMaxTotal(100);
        // 最大空闲数
        poolConfig.setMaxIdle(10);
        // 最大允许等待时间，如果超过这个时间还未获取到连接，则会报JedisException异常：
        // Could not get a resource from the pool
        poolConfig.setMaxWaitMillis(1000);
        Set<HostAndPort> nodes = new LinkedHashSet<HostAndPort>();
        nodes.add(new HostAndPort("192.168.66.129", 7001));
        nodes.add(new HostAndPort("192.168.66.129", 7002));
        nodes.add(new HostAndPort("192.168.66.129", 7003));
        nodes.add(new HostAndPort("192.168.66.131", 7004));
        nodes.add(new HostAndPort("192.168.66.131", 7005));
        nodes.add(new HostAndPort("192.168.66.131", 7006));
        JedisCluster cluster = new JedisCluster(nodes, poolConfig);
        String name = cluster.get("name");
        System.out.println(name);
        cluster.set("age", "18");
        System.out.println(cluster.get("age"));
        try {
            cluster.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
