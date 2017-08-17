package thread.multiply.syncode;

/**
 * 异步代码：fun_2不必等待fun_1执行完成才执行
 * Created by wangjianjun on 2017/8/17.
 */
public class ASynchronizedCode {

    public static void fun_1(){
        System.out.println("1");
    }

    public static void fun_2(){
        System.out.println("2");
    }

    public static void main(String[] args) {

        new Thread(){
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                fun_1();
            }
        }.start();

        new Thread(){
            @Override
            public void run() {
                fun_2();
            }
        }.start();
    }
}
