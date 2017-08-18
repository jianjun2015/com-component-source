package thread.multiply.synchronize.container.exception;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 抛出  ConcurrentModificationException
 * Created by wangjianjun on 2017/8/18.
 */
public class ConcurrentModificationExceptionClass {

    static ArrayList<Integer> list = new ArrayList<Integer>();

    public static void main(String[] args) {

//        fun_ConcurrentModificationException();
//        fun_ConcurrentModificationException_singleThread_salve();
        fun_ConcurrentModificationException_MultyThread();
    }

    /**
     * 迭代的时候修改抛出异常
     */
    public static void fun_ConcurrentModificationException(){
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(2);
        Iterator<Integer> iterator = list.iterator();
        while(iterator.hasNext()){
            Integer integer = iterator.next();
            if(integer==2)
                list.remove(integer);
        }
    }

    /**
     * 在迭代器中如果要删除元素的话，需要调用Itr类的remove方法。
     */
    public static void fun_ConcurrentModificationException_singleThread_salve(){
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        Iterator<Integer> iterator = list.iterator();
        while(iterator.hasNext()){
            Integer integer = iterator.next();
            if(integer==2)
                iterator.remove();
        }

        System.out.println(list.size());
    }

    /**
     * 抛出异常：解决办法
     * 1）在使用iterator迭代的时候使用synchronized或者Lock进行同步；
     * 2）使用并发容器CopyOnWriteArrayList代替ArrayList和Vector。
     */
    public static void fun_ConcurrentModificationException_MultyThread(){
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        Thread thread1 = new Thread(){
            public void run() {
                Iterator<Integer> iterator = list.iterator();
                while(iterator.hasNext()){
                    Integer integer = iterator.next();
                    System.out.println(integer);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
        };
        Thread thread2 = new Thread(){
            public void run() {
                Iterator<Integer> iterator = list.iterator();
                while(iterator.hasNext()){
                    Integer integer = iterator.next();
                    if(integer==2)
                        iterator.remove();
                }
            };
        };
        thread1.start();
        thread2.start();
    }
}
