package component.design.proxy.jdkproxy;


/**
 * @author wangjianjun
 *
 */
public class UserDao implements IUserDao {

	@Override
	public void save(String str) {
		// TODO Auto-generated method stub
		System.out.println("-----save--------"+str);

	}

}
