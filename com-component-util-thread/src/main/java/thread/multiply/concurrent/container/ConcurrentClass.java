package thread.multiply.concurrent.container;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 并发容器
 * 1）根据具体场景进行设计，尽量避免synchronized，提供并发性。
 * 2）定义了一些并发安全的复合操作，并且保证并发环境下的迭代操作不会出错。
 * Created by wangjianjun on 2017/8/20.
 */
public class ConcurrentClass {

    public static void main(String[] args) {
        fun_ConcurrentHashMap();
        fun_HashMap();
    }

    public static void fun_ConcurrentHashMap(){

        long start = System.currentTimeMillis();

        Map map = new ConcurrentHashMap();
        for (int i=0;i<1000;i++){
            map.put(i,i);
        }

        System.out.println("ConcurrentHashMap:"+(System.currentTimeMillis()-start));
    }

    public static void fun_HashMap(){

        long start = System.currentTimeMillis();

        Map map = Collections.synchronizedMap(new HashMap());
        for (int i=0;i<1000;i++){
            map.put(i,i);
        }

        System.out.println("HasMap:"+(System.currentTimeMillis()-start));
    }
}
