package component.annotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by wangjianjun on 2017/6/16.
 */
@MyClassAnnotation(url = "component.annotation.MySampleMain",desc = "the class name")
public class MySampleMain {

    @MyFieldAnnotation(url = "component.annotation.MySampleMain#id",desc = "the field id")
    public String id;

    @MyConstructorAnnotation(url = "component.annotation.MySampleMain#MySampleMain",desc = "the constructor MySampleMain")
    public MySampleMain() {
    }

    @MyMethodAnnotation(url = "component.annotation.MySampleMain#setId",desc = "the method setId")
    public void setId(String id) {
        this.id = id;
    }

    public static void main(String[] args) throws NoSuchMethodException, NoSuchFieldException, ClassNotFoundException {

        MySampleMain sampleMain = new MySampleMain();

//        自定义注解使用，可以通过反射得到注解信息
        Class c = Class.forName("component.annotation.MySampleMain");
        if (c.isAnnotationPresent(MyClassAnnotation.class)){
            MyClassAnnotation classAnnotation_ = (MyClassAnnotation) c.getAnnotation(MyClassAnnotation.class);
            System.out.println(classAnnotation_.desc());
            Method []methods = c.getMethods();
            for (Method method:methods){
                if (method.isAnnotationPresent(MyConstructorAnnotation.class)){
                    MyConstructorAnnotation constructorAnnotation_ = method.getAnnotation(MyConstructorAnnotation.class);
                    System.out.println(constructorAnnotation_.desc());
                }else
                if (method.isAnnotationPresent(MyMethodAnnotation.class)){
                    MyMethodAnnotation methodAnnotation_ = method.getAnnotation(MyMethodAnnotation.class);
                    System.out.println(methodAnnotation_.desc());
                }
            }
        }


        MyClassAnnotation classAnnotation = MySampleMain.class.getAnnotation(MyClassAnnotation.class);
        System.out.println(classAnnotation.url()+":"+classAnnotation.desc());

        Constructor constructor = sampleMain.getClass().getConstructor();
        MyConstructorAnnotation constructorAnnotation = (MyConstructorAnnotation) constructor.getAnnotation(MyConstructorAnnotation.class);
        System.out.println(constructorAnnotation.url()+":"+constructorAnnotation.desc());

        Method method = sampleMain.getClass().getDeclaredMethod("setId",String.class);
        MyMethodAnnotation myMethodAnnotation = method.getAnnotation(MyMethodAnnotation.class);
        System.out.println(myMethodAnnotation.url()+":"+myMethodAnnotation.desc());

        Field field = sampleMain.getClass().getDeclaredField("id");
        MyFieldAnnotation fieldAnnotation = field.getAnnotation(MyFieldAnnotation.class);
        System.out.println(fieldAnnotation.url()+":"+fieldAnnotation.desc());

    }
}
