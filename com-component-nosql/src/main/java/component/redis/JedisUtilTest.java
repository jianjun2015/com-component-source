package component.redis;

import org.junit.Test;
import redis.clients.jedis.Jedis;

/**
 * Created by wangjianjun on 2017/7/5.
 */
public class JedisUtilTest
{
    @Test
    public void jedisUtilTest_func(){

        Jedis jedis = RedisUtil.getJedis();
        jedis.set("ss","111");
        jedis.setex("sss",1,"222");//设置key有效存活时间
        jedis.getSet("ss","777");
        System.out.println(jedis.get("sss"));

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(jedis.get("ss"));
        System.out.println(jedis.get("hello"));

        try {
            RedisUtil.releseJedis(jedis);
            System.out.println(jedis.get("sss"));//jedis已经释放
        }catch (Exception e){
            System.out.println("出现异常:"+e.getMessage());
        }
    }
}
