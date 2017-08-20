package component.design.singleton;

public class Main {

	public static void main(String[] args) {
		//对比
		Singleton singleton1 = Singleton.getInstance();
		Singleton singleton2 = Singleton.getInstance();
		System.out.println(singleton1 == singleton2);
		
		//对比
		SingletonSec singletonSec1 = SingletonSec.getInstance_NoSecurty();
		SingletonSec singletonSec2 = SingletonSec.getInstance_NoSecurty();
		System.out.println(singletonSec1 == singletonSec2);
		
		//对比
		SingletonSec singletonSec3 = SingletonSec.getInstance_Securty();
		SingletonSec singletonSec4 = SingletonSec.getInstance_Securty();
		System.out.println(singletonSec3 == singletonSec4);

		EnumSingleton singleton = EnumSingleton.uniqueInstance;
		EnumSingleton singleton_ = EnumSingleton.uniqueInstance;
		System.out.println(singleton == singleton_);

	}

}
