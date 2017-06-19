package component.design.proxy.cglibproxy;

public class Main {
	
	public static void main(String[] args) {
		
		UserDao target = new UserDao();
		
		UserDao proxy = (UserDao) new ProxyFactory(target).getProxyInstance();
		
		proxy.save();
	}

}
