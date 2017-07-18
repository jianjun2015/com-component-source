package component.design.proxy.staticproxy;

/**
 * @author wangjianjun
 *
 */
public class Main {
	
	public static void main(String[] args) {
		
		UserDao target = new UserDao();
		
		UserDaoProxy proxy = new UserDaoProxy(target);
		
		proxy.save();
	}

}
