package component.design.singleton;

/**
 * 饿汉模式  线程不安全
 * @author wangjianjun
 *
 */
public class Singleton {
	
	private Singleton(){}
	
	private static final Singleton singleInstance = new Singleton();
	
	public static Singleton getInstance(){
		
		return singleInstance;
	}

}
