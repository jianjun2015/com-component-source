package component.catchpack;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 最近最少使用
 * @author wangjianjun
 *
 */
public class LRUCache<K,V> extends AbstractCacheMap<K, V>{

	public LRUCache(int cacheSize, long defaulExpire) {
		super(cacheSize, defaulExpire);
		// TODO Auto-generated constructor stub
		
		//LinkedHashMap ʵ��LRU�㷨
		this.cacheMap = new LinkedHashMap<K,CacheObject<K, V>>(cacheSize+1,1f,true){
			protected boolean removeEldesEntry(Map.Entry<K, CacheObject<K, V>> eldest){
				 return LRUCache.this.removeEldestEntry(eldest);
			}
		};
	}
	
	private boolean  removeEldestEntry(Map.Entry<K, CacheObject<K, V>> eldest) {
		
		if(cacheSize == 0)
			return false;
		
		return size()>cacheSize;
	}
	
	@Override
	protected int eliminateCache() {
		// TODO Auto-generated method stub
		if(!isNeedClearExpiredObject()){ 
			return 0;
		}
		
		Iterator<CacheObject<K, V>> iterator = cacheMap.values().iterator();
		int count = 0;
		
		while(iterator.hasNext()){
			CacheObject<K, V> cacheObject = iterator.next();
			if (cacheObject.isExpired()) {
				iterator.remove();
				count++;
			}
		}
		
		return 0;
	}
	
}
