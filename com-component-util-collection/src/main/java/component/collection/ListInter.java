package component.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * 有序  可重复
 * @author wangjianjun
 *
 */
public class ListInter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ListInter listInter = new ListInter();
		listInter.fun_ListRead();


	}

	/**
	 * 数据实现，父类有Object[] 数组，操作类似于数据
	 * 访问速度极快
	 * 数据增加删除慢
	 * 初始默认长度10
	 * 线程不安全,多线程使用Vector(其中绝大部分方法加了同步关键字修饰)
	 */
	public void fun_arrList(){

		List arrList = new ArrayList();
		arrList.add("AA");
	}

	/**
	 * 节点实现 java.util.LinkedList.Node<E> 操作类似于链表(双向循环链表)
	 * 访问速度慢
	 * 数据增加删除快
	 * 线程不安全
	 */
	public void fun_linkList(){

		List linkList = new LinkedList();
		linkList.add("XX");
	}

	public void fun_ListRead(){

		List<String> list = new ArrayList();
		list.add("AA");
		list.add("BB");
		list.add("CC");

		//第一种遍历
		for(String str:list){
			System.out.println(str);
		}

		//第二种遍历
		String[] arr = new String[list.size()];
		list.toArray(arr);
		for(String str:arr){
			System.out.println(str);
		}


		Iterator<String> it = list.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}

		List<String> lili = new LinkedList();
		lili.add("SS");
		lili.add("CC");
		Iterator<String> its = lili.iterator();
		while(its.hasNext()){
			System.out.println(its.next());
		}
	}

}
