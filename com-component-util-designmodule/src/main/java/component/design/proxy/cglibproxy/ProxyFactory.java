package component.design.proxy.cglibproxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class ProxyFactory implements MethodInterceptor{
	
	private Object target;
	
	public ProxyFactory(Object target) {
		super();
		this.target = target;
	}
	
	public Object getProxyInstance(){
		
		Enhancer en = new Enhancer();
		en.setSuperclass(target.getClass());
		en.setCallback(this);
		
		return en.create();
	}

	@Override
	public Object intercept(Object obj, Method method, Object[] args,
			MethodProxy proxy) throws Throwable {
		// TODO Auto-generated method stub
		
		System.out.println("----��ʼ����-----");
		
		Object returnValue = method.invoke(target, args);
		
		System.out.println("---�ύ����-----");
		
		return returnValue;
	}

}
