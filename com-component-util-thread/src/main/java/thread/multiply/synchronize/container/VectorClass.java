package thread.multiply.synchronize.container;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * 通过比较发现：vector(同步)执行时间iarrayList的两倍左右
 * Created by wangjianjun on 2017/8/18.
 */
public class VectorClass {
    static Vector<Integer> vector = new Vector<Integer>();

    public static void main(String[] args) {

        fun_safe();
    }

    public static void fun_function(){
        ArrayList<Integer> list = new ArrayList<>();
        Vector<Integer> vector = new Vector<>();

        long start = System.currentTimeMillis();
        for (int i=0;i<1000000;i++)
            list.add(i);
        long end = System.currentTimeMillis();
        System.out.println("ArrayList执行时间："+(end-start));

        long start_ = System.currentTimeMillis();
        for (int i=0;i<1000000;i++)
            vector.add(i);
        long end_ = System.currentTimeMillis();
        System.out.println("Vector执行时间："+(end_-start_));
    }

    /**
     * 会抛出异常，说明同步容器也不一定就安全。
     * 因为Vector是线程安全的，为什么还会报这个错？很简单，对于Vector，虽然能保证每一个时刻只能有一个线程访问它，
     * 但是不排除这种可能：某个线程获取到 i=9,另线程发起了remove(i),那这时候get就抛异常，数组越界
     */
    public static void fun_safe(){

        while(true) {
            for(int i=0;i<10;i++)
                vector.add(i);
            Thread thread1 = new Thread(){
                public void run() {
                    for(int i=0;i<vector.size();i++)
                        vector.remove(i);
                };
            };
            Thread thread2 = new Thread(){
                public void run() {
                    for(int i=0;i<vector.size();i++)
                        vector.get(i);
                };
            };
            thread1.start();
            thread2.start();
            while(Thread.activeCount()>10)   {

            }
        }

    }
}
