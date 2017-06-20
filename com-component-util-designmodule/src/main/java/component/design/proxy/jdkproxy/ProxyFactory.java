package component.design.proxy.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author wangjianjun
 *
 */
public class ProxyFactory {
	
	//ά��һ��Ŀ��Ķ���
	private Object target;

	public ProxyFactory(Object target) {
		this.target = target;
	}
	
	//��Ŀ��������ɴ������
	public Object getProxyInstance(){
		
		return Proxy.newProxyInstance(
				target.getClass().getClassLoader(), 
				target.getClass().getInterfaces(), 
				new InvocationHandler() {
					
					@Override
					public Object invoke(Object proxy, Method method, Object[] args)
							throws Throwable {
						// TODO Auto-generated method stub
						//ִ��Ŀ����󷽷�
						System.out.println("��ʼ����---");
						Object returnValue = method.invoke(target, args);
						System.out.println("�ύ����---");
						return returnValue;
					}
				});
	}

}
