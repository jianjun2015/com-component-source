package component.redis;

import redis.clients.jedis.JedisPool;

/**
 * Redis工具类
 * @author wangjianjun
 *
 */
public final class RedisUtil {

	private static String ADDR = "127.0.0.1";
	private static int PORT = 6379;
	private static String AUTH = "admin";//访问密码
	private static int MAX_ACTIVE = 1024;//可用连接实例的最大数目 默认8，-1不限制
	private static int MAX_IDLE=200;//控制一个redis pool空闲的实例数  默认8
	private static long MAX_WAIT=10000;//等待可用连接的最大时间，毫秒;超过抛JedisConnectionException
	private static long TIMEOUT = 10000;//最大延迟时间
	private static boolean TEST_ON_BORROW = true;//在borrow一个jedis实例时，是否提前进行validate操作，true则得到的jedis均是可用
	private static JedisPool jedisPool = null;//jedis pool

	//初始化redis
	/**
	 * 高版本的redis只能在配置文件进行配置
	 *  <bean id="jedisPoolConfig" class="redis.clients.jedis.JedisPoolConfig">  
	 <property name="maxIdle" value="${redis.pool.maxIdle}" />
	 <property name="maxTotal" value="${redis.pool.maxActive}" />
	 <property name="maxWaitMillis" value="${redis.pool.maxWait}" />
	 <property name="testOnBorrow" value="${redis.pool.testOnBorrow}" />
	 <property name="testOnReturn" value="${redis.pool.testOnReturn}" />
	 </bean>
	 */
	static{
		try{
			JedisPool jedisPool = new JedisPool();
//			jedisPool.

		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public RedisUtil() {
		// TODO Auto-generated constructor stub
	}
}
