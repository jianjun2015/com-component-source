package component.reflectuse;

import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangjianjun on 2017/6/20.
 */
public class ReflectOper {

    //通过反射操作list
    public static void func_list() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        List<Integer> list = new ArrayList<>();
        Method method = list.getClass().getMethod("add", Object.class);

        method.invoke(list,"AAAA");
        method.invoke(list,111);
        System.out.println(list.get(0)+" "+list.get(1));
    }

    //反射操作数组
    public static void func_array(){
        int[] temp = {1,2,3,4};

        Class<?> demo = temp.getClass().getComponentType();
        System.out.println("数组类型:"+demo.getName());
        System.out.println("数组长度:"+ Array.getLength(temp));
        System.out.println("第一个元素:"+Array.get(temp,0));

        Array.set(temp,0,100);
        System.out.println("修改后的第一个元素:"+Array.get(temp,0));
    }

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        func_array();
    }
}
