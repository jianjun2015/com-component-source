package component.design.proxy.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * Created by wangjianjun on 2017/9/26.
 */
public class Client {

    public static void main(String[] args) {

        IUserDao userDao = new UserDao();
        InvocationHandler handler = new DynamicProxy(userDao);

        IUserDao iUserDao = (IUserDao) Proxy.newProxyInstance(
                handler.getClass().getClassLoader(),
                handler.getClass().getInterfaces(),
                handler);

        System.out.println(iUserDao.getClass().getName());
        iUserDao.save("HAHA");
    }
}
