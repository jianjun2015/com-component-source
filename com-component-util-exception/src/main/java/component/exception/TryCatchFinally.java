package component.exception;

/**
 * Created by wangjianjun on 2017/7/19.
 */
public class TryCatchFinally {

    public static void main(String[] args) {

//        fun_try_catch();
//        fun_try_catch_finally();
        fun_try_finally();
    }

    public static void fun_try_catch(){
        try {
            int result = 10/2;
            System.out.println("try");
        }catch (ArithmeticException e){
            e.printStackTrace();
            System.out.println("catch");
        }

        System.out.println("return");

    }

    public static void fun_try_catch_finally(){
        try {
            System.out.println("tryStart");
            int result = 10/0;
            System.out.println("tryEnd");
        }catch (ArithmeticException e){
            e.printStackTrace();
            System.out.println("catch");
        }finally {
            System.out.println("finally");
        }

        System.out.println("return");

    }

    //如果抛异常 则先执行finally，然后抛出异常
    public static void fun_try_finally() throws ArithmeticException{
        try {
            int result = 10/0;
            System.out.println("try");
        }finally {
            System.out.println("finally");
        }

        System.out.println("return");

    }
}
