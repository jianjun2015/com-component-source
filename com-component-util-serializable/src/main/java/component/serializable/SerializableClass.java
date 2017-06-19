package component.serializable;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * 为了保存在内存中的各种对象的状态(即实例变量),并且可以把保存的对象状态再读出来
 *
 * 什么情况下需要序列化 a）当你想把的内存中的对象状态保存到一个文件中或者数据库中时候； b）当你想用套接字在网络上传送对象的时候；
 * c）当你想通过RMI传输对象的时候；
 *
 * @author wangjianjun
 *
 */
public class SerializableClass implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 3893763407634255098L;

	public static void main(String[] args) {

		SerializableClass sc = new SerializableClass();
		sc.fun_serialize();
		sc.fun_de_serialize();
	}

	/**
	 * 序列号
	 */
	public void fun_serialize() {

		ObjectOutputStream oos = null;

		try {
			oos = new ObjectOutputStream(new FileOutputStream("test.txt"));
			Person p = new Person("张三", 21,"123123");
			p.setDefaultValue("AAAAAA");
			oos.writeObject(p);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (oos != null) {
				try {
					oos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * 反序列化
	 */
	public void fun_de_serialize(){

		ObjectInputStream ois = null;

		try {
			ois = new ObjectInputStream(new FileInputStream("test.txt"));
			try {
				Person p = (Person) ois.readObject();
				System.out.println(p.toString()+p.getDefaultValue());
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if (ois != null) {
				try {
					ois.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

}
