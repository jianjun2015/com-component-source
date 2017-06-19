package component.catchpack;

/**
 * 缓存结构
 * @author wangjianjun
 *
 * @param <K>
 * @param <V>
 */
public interface Cache<K,V> {

	/**
	 *缓存空间
	 * @return
	 */
	int size();
	
	
	/**
	 * 返回默认存活时间
	 * @return
	 */
	long getDefaultExpire();
	
	
	/**
	 * 插入
	 * @param key
	 * @param value
	 */
	void put(K key, V value);
	
	/**
	 * 插入
	 * @param key
	 * @param value
	 * @param expire
	 */
	void put(K key, V value, long expire);
	
	/**
	 * 获取
	 * @param key
	 * @return
	 */
	V get(K key);
	
	
	/**
	 * 淘汰
	 * @return ��ɾ�������С
	 */
	int eliminate();
	
	/**
	 * 满
	 * @return
	 */
	boolean isFull();
	
	/**
	 * 移除
	 */
	void remove(K key);
	
	/**
	 * 清空
	 */
	void clear();
	
	/**
	 * 缓存数据量
	 * @return
	 */
	int getCacthSize();
	
	/**
	 * 是否为空
	 * @return
	 */
	boolean isEmpty();
}
