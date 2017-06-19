package component.catchpack;

import java.util.HashMap;
import java.util.Iterator;

public class LFUCache<K,V> extends AbstractCacheMap<K, V>{

	public LFUCache(int cacheSize, long defaulExpire) {
		super(cacheSize, defaulExpire);
		// TODO Auto-generated constructor stub
		cacheMap = new HashMap<K,CacheObject<K,V>>();
	}

	@Override
	protected int eliminateCache() {
		// TODO Auto-generated method stub
		Iterator<CacheObject<K, V>> iterator = cacheMap.values().iterator();
		int count = 0;
		
		long minAccessCount = Long.MAX_VALUE;
		while(iterator.hasNext()){
			CacheObject<K, V> cacheObject = iterator.next();
			if(cacheObject.isExpired()){
				iterator.remove();
				count++;
				continue;
			}else{
				minAccessCount  = Math.min(cacheObject.accessCount , minAccessCount)  ;
			}
		}
		if(count>0)
			return count;
		
		if(minAccessCount != Long.MAX_VALUE ){
			
			iterator = cacheMap.values().iterator();
			while(iterator.hasNext()){
				CacheObject<K, V> cacheObject = iterator.next();
				cacheObject.accessCount  -=  minAccessCount ;
				if(cacheObject.accessCount <= 0){
					iterator.remove();
					count++;
				}
			}
		}
		
		return count;
	}

}
