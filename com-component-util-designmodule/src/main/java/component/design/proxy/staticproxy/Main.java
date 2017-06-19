package component.design.proxy.staticproxy;

/**
 * ��̬�����ܽ�:
1.���������ڲ��޸�Ŀ�����Ĺ���ǰ����,��Ŀ�깦����չ.
2.ȱ��:
��Ϊ���������Ҫ��Ŀ�����ʵ��һ���Ľӿ�,���Ի��кܶ������,��̫��.ͬʱ,һ���ӿ����ӷ���,Ŀ�������������Ҫά��.
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
