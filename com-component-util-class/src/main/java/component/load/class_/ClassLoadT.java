package component.load.class_;

import java.util.List;

/**
 * Created by wangjianjun on 2017/7/14.
 */
public class ClassLoadT {

    /**
     * 解释一下：
     1、ClassLoaderTest类是用户定义的类，位于CLASSPATH下，由系统/应用程序类加载器加载。
     2、System类与List类都属于Java核心类，由祖先类启动类加载器加载，而启动类加载器是在JVM内部通过C/C++实现的，并不是Java，自然也就不能继承ClassLoader类，自然就不能输出其名称。
     3、而箭头项代表的就是类加载的流程，层级委托，从祖先类加载器开始，直到系统/应用程序类加载器处才被加载。
     * @param args
     */
    public static void main(String[] args) {

        System.out.println("ClassLoadT类加载器:"+ClassLoadT.class.getClassLoader());
        System.out.println("System类加载器:"+System.class.getClassLoader());
        System.out.println("List类加载器:"+List.class.getClassLoader());

        ClassLoader cl = ClassLoadT.class.getClassLoader();
        while (cl != null){
            System.out.print(cl.getClass().getName()+"->");
            cl = cl.getParent();
        }

        System.out.println("cl:"+cl);
    }
}
