package component.baseutil;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 反射操作
 * Created by wangjianjun on 2017/9/25.
 */
public class ReflectOper {

    public static void main(String[] args) {
        A a = new A();
        Class ca = a.getClass();
        Class ca_ = null;

        try {
            ca_ = Class.forName("component.baseutil.A");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            Method  method = ca.getMethod("add",new Class[]{int.class,int.class});
            Method  method_ = ca_.getMethod("add",int.class,int.class);

            method.invoke(a,10,10);
            method_.invoke(a,10,20);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

}

