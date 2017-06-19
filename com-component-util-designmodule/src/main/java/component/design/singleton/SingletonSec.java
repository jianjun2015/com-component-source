package component.design.singleton;

/**
 * 饱汉模式	线程安全
 * @author wangjianjun
 *
 */
public class SingletonSec {

	private SingletonSec(){}
	
	private static SingletonSec singletonSec;
	
	public static SingletonSec getInstance_NoSecurty(){
		
		if(singletonSec == null)
			singletonSec =  new SingletonSec();
		
		return singletonSec;
	}
	
	public static synchronized SingletonSec getInstance_Securty(){
		
		if(singletonSec == null)
			singletonSec =  new SingletonSec();
		
		return singletonSec;
	}
}
