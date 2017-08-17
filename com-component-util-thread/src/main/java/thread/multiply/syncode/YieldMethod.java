package thread.multiply.syncode;

/**
 * Created by wangjianjun on 2017/8/17.
 */
public class YieldMethod {

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
                yield();//让当前线程交出cpu权限，转入就绪状态
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
