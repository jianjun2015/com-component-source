package component.collection;

import org.springframework.util.LinkedCaseInsensitiveMap;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Map 是顶层接口
 * @author wangjianjun
 *
 */
public class MapInter {

	public static void main(String[] args) {
		MapInter mapInter = new MapInter();
//		mapInter.fun_hashTable();
//		mapInter.fun_hashMap();
//		mapInter.fun_LinkedHashMap();
//		mapInter.fun_TreeMap();
		mapInter.removeItem();

	}

	/**
	 * 不同：
	 * 继承和实现方式不同--Hashtable 继承Diction
	 * 线程安全不同--Hashtable：适用于多线程 函数加了同步关键字 线程安全,HashMap单线程
	 * 对null值的处理不同--HashMap的key、value都可以为null，保留最后一个，Hashtable的key或value，都不能为null！否则，会抛出异常NullPointerException。
	 * 支持的遍历种类不同--HashMap只支持Iterator(迭代器)遍历，而Hashtable支持Iterator(迭代器)和Enumeration(枚举器)两种方式遍历。
	 * 通过Iterator迭代器遍历时，遍历的顺序不同--HashMap是“从前向后”的遍历数组,Hashtabl是“从后往前”的遍历数组
	 * 容量的初始值 和 增加方式都不一样--HashMap默认的“加载因子”是0.75, 默认的容量大小是16,扩增x2。Hashtable默认的“加载因子”是0.75, 默认的容量大小是11,扩增x2+1。
	 * 添加key-value时的hash值算法不同--HashMap添加元素时，是使用自定义的哈希算法。Hashtable没有自定义哈希算法，而直接采用的key的hashCode()。
	 *
	 */
	public void fun_hashTable(){

		Map map = new Hashtable();
		map.put(null, "XXX");//编译ok，执行抛空指针异常
		System.out.println(map.get(null));


	}

	/**
	 * 无序
	 * 初始化默认16
	 * 负载因子0.75
	 * 容量为2*  如  传入1000 则容量为1024
	 */
	public void fun_hashMap(){

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("AA", "Key1");
		map.put("BB", "Key2");
		map.put("VV", "Key3");
		map.put("AS", "Key4");
		map.put(null, null);//OK
		fun_mapRead(map);

		//key值不区分大小写
		Map<String,Object> objectMap = new LinkedCaseInsensitiveMap<>();
		objectMap.put("NAME","zhangsan");
		objectMap.get("namE");

	}

	public void fun_concurretHashMap(){
		Map map = new ConcurrentHashMap();//线程同步仅限于原子操作
		map.put("key_","");

		map.put("kk",map.get("kk")+"");//不适用
	}

	//输入顺序
	public void fun_LinkedHashMap(){

		Map<String, Object> map = new LinkedHashMap<String, Object>();
		map.put("AA", "Key1");
		map.put("BB", "Key2");
		map.put("VV", "Key3");
		map.put("AS", "Key4");
		fun_mapRead(map);
	}

	//key排序
	public void fun_TreeMap(){

		Map<String, Object> map = new TreeMap<String, Object>();
		map.put("AA", "Key1");
		map.put("BB", "Key2");
		map.put("VV", "Key3");
		map.put("AS", "Key4");
		fun_mapRead(map);
	}


	public void fun_mapRead(Map<String, Object> map){

		Set<String> set = map.keySet();
		Iterator<String> it = set.iterator();
		while(it.hasNext()){
			String key = it.next();
			System.out.println(key+":"+map.get(key));
		}

		System.out.println();
		Set<Map.Entry<String,Object>> setEntrys = map.entrySet();
		Iterator<Map.Entry<String,Object>> its = setEntrys.iterator();
		while(its.hasNext()){
			Map.Entry<String,Object> keyValue= its.next();
			System.out.println(keyValue.getKey()+":"+keyValue.getValue());
		}

	}

	public void removeItem(){

		Map map =new LinkedHashMap<String, Object>();
		map.put("AA", 1);
		map.put("BB", 1);
		map.put("CC", 1);
		map.put("DD", 1);
		map.put("EE", 1);
		map.put("FF", 1);

		System.out.println(map);
	}

}
