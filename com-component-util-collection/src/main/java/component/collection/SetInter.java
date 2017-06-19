package component.collection;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * Set无序不重复  位置由hashCode决定，在内存中是固定的
 * @author wangjianjun
 *
 */
public class SetInter {

	public static void main(String[] args) {
		SetInter setInter = new SetInter();
		setInter.func_HashSet();
		setInter.fun_LinkedHashSet();
		setInter.fun_TreeSet();
	}

	/**
	 * HashSet 通过HashMap来实现  hashSet即是HashMap中的Key值
	 */
	public void func_HashSet(){


		Set<String> set = new HashSet();

		set.add("AA4");
		set.add("AA1");
		set.add("AA1");
		set.add("AA");
		set.add("AA2");
		set.add("AA3");
		set.add("AA");
		set.add("AA");

		for(String str:set){
			System.out.println(str);
		}

		System.out.println("\n\n\n\n\n\n\n");
		String[] arrs = new String[set.size()];
		set.toArray(arrs);
		for(String str:arrs){
			System.out.println(str);
		}

	}

	/**
	 * LinkHashSet不仅是Set接口的子接口而且还是上面HashSet接口的子接口
	 */
	public void fun_LinkedHashSet(){

		Set<String> set = new LinkedHashSet();
		set.add("CC");

	}

	/**
	 * 对元素进行排序 通过TreeMap实现，加了排序功能
	 */
	public void fun_TreeSet(){

		Set<String> set = new TreeSet();
		set.add("AA");
		set.add("BB");
		set.add("CC");
		set.add("AB");

		for(String str:set){
			System.out.println(str);
		}
	}

}
