package thread.multiply.synchronized_;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangjianjun on 2017/8/17.
 */
public class StaticSynchronized {
    public static void main(String[] args) {
        final InsertData_ insertData = new InsertData_();

        new Thread(){
            @Override
            public void run() {
                insertData.insert();
            }
        }.start();

        new Thread(){
            @Override
            public void run() {
                insertData.insert_();
            }
        }.start();
    }
}


class InsertData_{
    //普通方法
    public synchronized void insert(){
        try {
            System.out.println("insert....start");
            Thread.sleep(5000);
            System.out.println("insert....end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //synchronized 同步方法
    public static synchronized void insert_(){
        System.out.println("static....start");
        System.out.println("static....end");
    }
}
