package thread.multiply.syncode;

/**
 * 典型的同步代码：必须fun_1执行完才执行fun_2
 * Created by wangjianjun on 2017/8/17.
 */
public class SynchronizedCode {

    public static void fun_1(){
        System.out.println("1");
    }

    public static void fun_2(){
        System.out.println("2");
    }

    public static void main(String[] args) {

        fun_1();
        fun_2();
    }
}
