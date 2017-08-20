package thread.multiply.test;

/**
 * Created by wangjianjun on 2017/8/20.
 */
public class ThredOrder {

    public static void main(String[] args) {
        //T1-T2-T3
        Thread_T3 t3 = new Thread_T3();
        t3.start();
    }

    public static void fun_T3T2T1(){
        Thread thread_1 = new Thread(){
            @Override
            public void run() {
                System.out.println("T1");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Thread thread_2 = new Thread(){
            @Override
            public void run() {
                System.out.println("T2");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Thread thread_3 = new Thread(){
            @Override
            public void run() {
                System.out.println("T3");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        //执行顺序T3-T2-T1
        thread_1.start();
        thread_2.start();
        thread_3.start();

        try {
            thread_3.join();
            thread_2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Thread_T1 extends Thread{
    @Override
    public void run() {
        System.out.println("T1");
    }
}
class Thread_T2 extends Thread{
    @Override
    public void run() {

        Thread_T1 t1  = new Thread_T1();
        t1.start();
        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("T2");
    }
}
class Thread_T3 extends Thread{
    @Override
    public void run() {

        Thread_T2 t2  = new Thread_T2();
        t2.start();
        try {
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("T3");
    }
}
