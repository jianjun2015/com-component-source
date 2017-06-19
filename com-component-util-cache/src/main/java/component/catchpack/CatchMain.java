package component.catchpack;

/**
 * 缓存算法：
 * LRU(Least Recently Used ，最近最少使用)--被访问优先级提高;--适应热操作
 * LFU(Least Frequently Used，最不经常使用)--访问次数;--适应偶发性间歇性的
 * FIFO(First In First Out ，先进先出)--使用率最低
 *
 * 评价一个算法好坏：命中率高、算法容易实现
 * @author wangjianjun
 *
 */
public class CatchMain {
	
	
	public static void main(String[] args) {
		
		LRUCache<String, Object> lru = new LRUCache(5, 0);

		lru.put("AA", 1);
		lru.put("BB", 2);
		lru.put("CC", 3);
		lru.put("DD", 4);
		lru.put("EE", 5);
		lru.put("FF", 6);
		

		System.out.println(lru.getCacheSize());
		System.out.println(lru.get("AA"));
		System.out.println(lru.get("BB"));
		System.out.println(lru.get("CC"));
		System.out.println(lru.get("DD"));
		System.out.println(lru.get("EE"));
		System.out.println(lru.get("FF"));
	}

}
