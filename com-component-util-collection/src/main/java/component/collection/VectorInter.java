package component.collection;

import java.util.Vector;

public class VectorInter {


	public static void main(String[] args) {

	}

	/**
	 * 数据实现，父类有Object[] 数组，操作类似于数据
	 * 访问速度极快
	 * 数据增加删除慢
	 * 初始默认长度10
	 * 线程安全(其中绝大部分方法加了同步关键字修饰)
	 */
	public void func_vector(){

		Vector vector = new Vector();
		vector.add("AA");
	}

}

