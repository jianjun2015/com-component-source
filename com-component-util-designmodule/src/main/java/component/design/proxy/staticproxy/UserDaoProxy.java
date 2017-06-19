package component.design.proxy.staticproxy;

/**
 * ������󣬾�̬����
 * @author wangjianjun
 *
 */
public class UserDaoProxy implements IUserDao {
	
	private IUserDao target;
	
	public UserDaoProxy(IUserDao target) {
		// TODO Auto-generated constructor stub
		this.target = target;
	}

	@Override
	public void save() {
		// TODO Auto-generated method stub
		System.out.println("----��������-------");
		target.save();
		System.out.println("------�ύ����------");

	}

}
