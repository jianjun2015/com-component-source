package component.design.proxy.cglibproxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * CGLib采用了非常底层的字节码技术，其原理是通过字节码技术为一个类创建子类，并在子类中采用方法拦截的技术拦截所有父类方法的调用，顺势织入横切逻辑。
 */
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
		
		System.out.println("前序动作");
		
		Object returnValue = method.invoke(target, args);
		
		System.out.println("前序动作");
		
		return returnValue;
	}

}
