package component.redis;

import org.junit.Before;
import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Redis 持久化
 * Rdb(redis系统默认持久化策略):优点--持久化文件只包含一个文件,对灾难恢复、主从恢复效率比较高,持久化工作：子进程  缺点--数据安全性不是很好
 * Aof 优点--根据redis aof同步策略，数据有更高安全性  缺点--性能比Rdb低
 * @author wangjianjun
 *
 */
public class RedisTest {

	private Jedis jedis;

	@Before
	public void setup() {
		// TODO Auto-generated method stub
		String host = "192.168.66.129";
		int port = 6379;
		String password="admin";
		jedis = new Jedis(host, port);
//		jedis.auth(password);

	}

	/**
	 * String 类型测试
	 */

	@Test
	public void stringTest(){

		String key = "name";
		String value = "LISI";

		//添加数据
		jedis.set(key, value);
		System.out.println("添加数据:"+jedis.get(key));

		//拼接数据
		jedis.append(key, " AND ZHANGSAN");
		System.out.println("拼接数据"+jedis.get(key));

		//删除数据
		jedis.del(key);
		System.out.println("删除数据:"+jedis.get(key));

		//设置多个数据
		jedis.mset(key, value,"key1","value1","age","20");
		System.out.println(jedis.get(key)+"、"+jedis.get("key1")+"、"+jedis.get("age"));

		//数据类型 加减
		jedis.incr("age");
		jedis.decr("age");
		jedis.incrBy("age", 9);
		System.out.println(jedis.get("age"));

	}

	/**
	 * HashMap类型测试
	 */
	@Test
	public void hashMapTest(){

		String key = "information";

		Map<String, String> map = new HashMap<String, String>();
		map.put("name", "zhangsan");
		map.put("age", "21");
		map.put("sex", "male");

		//添加Map数据  取数据如果没有则null
		jedis.hmset(key, map);
		System.out.println(jedis.hmget(key, "name","age","sex"));

		//删除数据
		jedis.hdel(key, "name");
		System.out.println(jedis.hmget(key, "name"));

		//map的key个数
		System.out.println(jedis.hlen(key));

		//判断map对象 的key
		System.out.println(jedis.hkeys(key));

		//判断对象是否存在
		System.out.println(jedis.exists(key));

		//返回map对象所以value值
		System.out.println(jedis.hvals(key));

		//key迭代
		Iterator<String> it = jedis.hkeys(key).iterator();
		while(it.hasNext()){
			String k = it.next();
			System.out.println(k+"-"+jedis.hmget(key, k));
		}
	}

	/**
	 * list类型测试
	 */
	@Test
	public void listTest(){

		String key = "infoList";

		//情况
		jedis.del(key);

		System.out.println(jedis.lrange(key, 0, -1));

		// 添加数据
		jedis.lpush(key, "Usher");
		jedis.lpush(key, "sex");
		jedis.lpush(key, "age");

		System.out.println(jedis.lrange(key, 0, -1));
		System.out.println(jedis.lpop(key));
	}

	/**
	 * set类型测试
	 */
	@Test
	public void setTest(){

		String key = "uu";
		jedis.sadd(key, "use");
		jedis.sadd(key, "uss");
		jedis.sadd(key, "kk");

		System.out.println(jedis.smembers(key));

		jedis.srem(key, "kk");
		System.out.println(jedis.smembers(key));

		//是否存在
		System.out.println(jedis.sismember(key, "uss"));

		//返回集合个数
		System.out.println(jedis.scard(key));

		//随机返回
		System.out.println(jedis.srandmember(key));

	}

	//排序测试
	@Test
	public void sortTest(){

		String key = "sort";

		jedis.del(key);//清空

		jedis.rpush(key, "1");
		jedis.lpush(key, "2");
		jedis.lpush(key, "3");
		jedis.lpush(key, "4");

		System.out.println(jedis.lrange(key, 0, -1));

		System.out.println(jedis.sort(key));//排序不是硬排序
		System.out.println(jedis.lrange(key, 0, -1));
	}

	/**
	 * 中午测试
	 */
	@Test
	public void chineseTest(){

		jedis.set("nameKey", "中文测试");
		System.out.println(jedis.get("nameKey"));
	}



}
