package component.load.class_;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by wangjianjun on 2017/7/13.
 */
public class ClassLoaderTest {

    public static void main(String[] args) throws Exception {

        //匿名内部类实现自定义类加载器
        ClassLoader myClassLoader = new ClassLoader() {
            @Override
            protected Class<?> findClass(String name) throws ClassNotFoundException {

                String fileName = name.substring(name.lastIndexOf(".")+1)+".class";
                InputStream inputStream = getClass().getResourceAsStream(fileName);
                if (inputStream == null) {
                    throw new RuntimeException("Could not found class file:" + fileName);
                }

                try {
                    byte[] b = new byte[inputStream.available()];
                    return defineClass(name,b,0,b.length);
                } catch (IOException e) {
                    throw new ClassNotFoundException(name);
                }
            }
        };

        Object obj1 = ClassLoaderTest.class.getClassLoader().loadClass("component.load.class_.ClassLoaderTest").newInstance();
        System.out.println(obj1.getClass());
        System.out.println(obj1 instanceof component.load.class_.ClassLoaderTest);



        Object obj = myClassLoader.loadClass("component.load.class_.ClassLoaderTest").newInstance();
        System.out.println(obj.getClass());
        System.out.println(obj instanceof component.load.class_.ClassLoaderTest);
//        System.out.println(obj.equals(component.load.class_.ClassLoaderTest.class));
    }

    protected synchronized Class<?> loadClass(String name, Boolean resolve) throws ClassNotFoundException{

//        Class c = findLoadedClass(name);
        return null;
    }
}
