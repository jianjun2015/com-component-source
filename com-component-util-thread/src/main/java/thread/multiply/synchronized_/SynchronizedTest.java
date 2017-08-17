package thread.multiply.synchronized_;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangjianjun on 2017/8/17.
 */
public class SynchronizedTest {

    public static void main(String[] args) {
        final InsertData insertData = new InsertData();

        new Thread(){
            @Override
            public void run() {
                insertData.insert_(Thread.currentThread());
            }
        }.start();

        new Thread(){
            @Override
            public void run() {
                insertData.insert_(Thread.currentThread());
            }
        }.start();
    }
}


class InsertData{
    private List<Integer> list = new ArrayList<>();
    private Object object = new Object();//每个对象只有一个锁

    //普通方法
    public void insert(Thread thread){
        for (int i=0;i<5;i++){
            System.out.println(thread.getName()+"在插入数据："+i);
            list.add(i);
        }
    }

    //synchronized 同步方法
    public synchronized void insert_(Thread thread){
        for (int i=0;i<5;i++){
            System.out.println(thread.getName()+"在插入数据："+i);
            list.add(i);
        }
    }

    //synchronized 修饰代码块
    public void insert__(Thread thread){
        synchronized (this) {
            for (int i = 0; i < 5; i++) {
                System.out.println(thread.getName() + "在插入数据：" + i);
                list.add(i);
            }
        }
    }

    //synchronized 修饰代码块
    public void insert___(Thread thread){
        synchronized (object) {
            for (int i = 0; i < 5; i++) {
                System.out.println(thread.getName() + "在插入数据：" + i);
                list.add(i);
            }
        }
    }
}
