package component.catchpack;

import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 基本实现抽象类
 * @author wangjianjun
 *
 * @param <K>
 * @param <V>
 */
public abstract class AbstractCacheMap<K,V> implements Cache<K, V> {

	class CacheObject<K2,V2>{

		public CacheObject(K2 key,V2 value,long ttl) {
			// TODO Auto-generated constructor stub
			this.key = key;
			this.cacheObject = value;
			this.ttl = ttl;
			this.accessCount = System.currentTimeMillis();
		}

		final K2 key;
		final V2 cacheObject;
		long lastAccess;//最近访问时间
		long accessCount;//访问次数
		long ttl;//对象存活时间

		//对象是否存活
		boolean isExpired(){

			if(ttl == 0){
				return false;
			}

			return lastAccess+ttl<System.currentTimeMillis();
		}

		V2 getObject() {
			lastAccess = System.currentTimeMillis();
			accessCount++;
			return cacheObject;
		}

	}

	protected Map<K,CacheObject<K,V>> cacheMap;

	private final ReentrantReadWriteLock cacheLock = new ReentrantReadWriteLock();

	private final Lock readLock = cacheLock.readLock();

	private final Lock writeLock = cacheLock.writeLock();

	protected int cacheSize;//缓存大小  0-无限制

	protected boolean existCustomExpire;//是否设置默认过期时间

	public int getCacheSize(){
		return cacheSize;
	}

	public long defaultExpire;//默认过期时间，0--不过期

	public AbstractCacheMap(int cacheSize,long defaulExpire) {

		this.cacheSize = cacheSize;
		this.defaultExpire = defaulExpire;
	}

	protected boolean  isNeedClearExpiredObject(){

		return this.defaultExpire > 0 || this.existCustomExpire;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return this.cacheMap.size();
	}

	@Override
	public long getDefaultExpire() {
		// TODO Auto-generated method stub
		return this.defaultExpire;
	}

	@Override
	public void put(K key, V value) {
		// TODO Auto-generated method stub
		put(key, value,this.defaultExpire);

	}

	@Override
	public void put(K key, V value, long expire) {
		// TODO Auto-generated method stub
		writeLock.lock();

		try{

			CacheObject<K,V> co = new CacheObject<K, V>(key, value, expire);

			if(expire != 0){
				existCustomExpire = true;
			}

			if(isFull()){
				eliminate();
			}

			cacheMap.put(key, co);
		}finally{
			writeLock.unlock();
		}
	}

	@Override
	public V get(K key) {
		// TODO Auto-generated method stub

		readLock.lock();

		try{

			CacheObject<K,V> co = cacheMap.get(key);
			if(co == null)
				return null;

			if(co.isExpired() == true){
				cacheMap.remove(key);
				return null;
			}
			return co.cacheObject;

		}finally{
			readLock.unlock();
		}
	}

	@Override
	public int eliminate() {
		// TODO Auto-generated method stub
		writeLock.lock();

		try{

			return eliminateCache();

		}finally{
			writeLock.unlock();
		}
	}

	/**
	 * 具体实现算法实现
	 * @return
	 */
	protected abstract int eliminateCache();

	@Override
	public boolean isFull() {
		// TODO Auto-generated method stub
		if(cacheSize == 0){
			return false;
		}

		return cacheMap.size()>=cacheSize;
	}

	@Override
	public void remove(K key) {
		// TODO Auto-generated method stub
		writeLock.lock();

		try{

			cacheMap.remove(key);

		}finally{
			writeLock.unlock();
		}

	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		writeLock.lock();

		try{

			cacheMap.clear();

		}finally{
			writeLock.unlock();
		}

	}

	@Override
	public int getCacthSize() {
		// TODO Auto-generated method stub
		return this.cacheSize;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return size()==0;
	}

}
