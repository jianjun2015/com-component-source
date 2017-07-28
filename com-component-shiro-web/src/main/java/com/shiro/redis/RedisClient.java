package com.shiro.redis;

import org.apache.shiro.codec.Base64;
import org.apache.shiro.session.Session;
import redis.clients.jedis.*;

import java.io.*;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created by wangjianjun on 2017/7/28.
 */
public class RedisClient {

    private static JedisPool pool;
    private static String redisServerIp="192.168.66.129";
    private static int port = 6379;

    private static void createJedisPool(){

        //单机redis联机
        // 建立连接池配置参数
        JedisPoolConfig config = new JedisPoolConfig();
        // 设置最大连接数
        config.setMaxTotal(1000);
        // 设置最大阻塞时间，记住是毫秒数milliseconds
        config.setMaxWaitMillis(1000);
        // 设置空间连接
        config.setMaxIdle(10);
        // 创建连接池
        pool = new JedisPool(config, redisServerIp, port);

//       集群redis
    /*    JedisPoolConfig poolConfig = new JedisPoolConfig();
        // 最大连接数
        poolConfig.setMaxTotal(100);
        // 最大空闲数
        poolConfig.setMaxIdle(10);
        // 最大允许等待时间，如果超过这个时间还未获取到连接，则会报JedisException异常：
        // Could not get a resource from the pool
        poolConfig.setMaxWaitMillis(1000);
        Set<HostAndPort> nodes = new LinkedHashSet<HostAndPort>();
        nodes.add(new HostAndPort("192.168.83.128", 6379));
        nodes.add(new HostAndPort("192.168.83.128", 6380));
        nodes.add(new HostAndPort("192.168.83.128", 6381));
        nodes.add(new HostAndPort("192.168.83.128", 6382));
        nodes.add(new HostAndPort("192.168.83.128", 6383));
        nodes.add(new HostAndPort("192.168.83.128", 6384));
        JedisCluster cluster = new JedisCluster(nodes, poolConfig);
        String name = cluster.get("name");
        System.out.println(name);
        cluster.set("age", "18");
        System.out.println(cluster.get("age"));
        try {
            cluster.close();
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }

    /**
     * 在多线程环境同步初始化
     */
    private static synchronized void poolInit() {
        if (pool == null)
            createJedisPool();
    }

    /**
     * 获取一个jedis 对象
     *
     * @return
     */
    private static Jedis getJedis() {

        if (pool == null)
            poolInit();
        return pool.getResource();
    }

    /**
     * 归还一个连接
     *
     * @param jedis
     */
    private static void returnRes(Jedis jedis) {
        if (jedis != null)
            jedis.close();
    }

    void set(String sessionId, Session session) {
        jedis = getJedis();
        jedis.set(sessionId, serialize(session));
        returnRes(jedis);
    }

    void replace(String sessionId, Session session) {
        set(sessionId, session);

    }

    Jedis jedis = null;

    void delete(String sessionId) {
        jedis = getJedis();
        jedis.del(sessionId);
        returnRes(jedis);
    }

    Object get(String sessionId) {
        jedis = getJedis();
        Object obj = deserialize(jedis.get(sessionId));
        returnRes(jedis);
        return obj;
    }

    private static Object deserialize(String str) {
        ByteArrayInputStream bis = null;
        ObjectInputStream ois = null;
        try {
            bis = new ByteArrayInputStream(Base64.decode(str));
            ois = new ObjectInputStream(bis);
            return ois.readObject();
        } catch (Exception e) {
            throw new RuntimeException("deserialize session error", e);
        } finally {
            try {
                ois.close();
                bis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    private static String serialize(Object obj) {
        ByteArrayOutputStream bos = null;
        ObjectOutputStream oos = null;
        try {
            bos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(bos);
            oos.writeObject(obj);
            return Base64.encodeToString(bos.toByteArray());
        } catch (Exception e) {
            throw new RuntimeException("serialize session error", e);
        } finally {
            try {
                oos.close();
                bos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
