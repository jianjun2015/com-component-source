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

        /**
         * loader:　　一个ClassLoader对象，定义了由哪个ClassLoader对象来对生成的代理对象进行加载
         interfaces:　　一个Interface对象的数组，表示的是我将要给我需要代理的对象提供一组什么接口，如果我提供了一组接口给它，那么这个代理对象就宣称实现了该接口(多态)，这样我就能调用这组接口中的方法了
         h:　　一个InvocationHandler对象，表示的是当我这个动态代理对象在调用方法的时候，会关联到哪一个InvocationHandler对象上
         */
        IUserDao iUserDao = (IUserDao) Proxy.newProxyInstance(
                handler.getClass().getClassLoader(),
                userDao.getClass().getInterfaces(),
                handler);

//        IUserDao iUserDao = (IUserDao) object;

        System.out.println(iUserDao.getClass().getName());
        iUserDao.save("HAHA");
    }
}
