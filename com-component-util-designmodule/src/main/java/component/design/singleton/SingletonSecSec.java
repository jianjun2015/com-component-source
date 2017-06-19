package component.design.singleton;

public class SingletonSecSec {

	//volatile 修饰符意思是每次从内存获取
	//高性能 多线程安全
	private volatile static SingletonSecSec singletonSecSec;
	
	private SingletonSecSec(){}
	
	public static SingletonSecSec getInstance(){
		
		if(singletonSecSec == null){
			synchronized(SingletonSecSec.class){
				if(singletonSecSec == null){
					singletonSecSec = new SingletonSecSec();
				}
			}
		}
		
		return singletonSecSec;
	}
}
