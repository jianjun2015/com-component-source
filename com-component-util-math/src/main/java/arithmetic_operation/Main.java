package arithmetic_operation;

/**
 * Created by wangjianjun on 2017/9/26.
 */
public class Main {

    public static void main(String[] args) {
        func_addPlus();
    }

    public static void func_addPlus(){
        int i=10;
        System.out.println("i="+i);
        System.out.println("i++="+i++);
        System.out.println("i="+i);

        int j=10;
        System.out.println("j=:"+j);
        System.out.println("j--=:"+j--);
        System.out.println("j="+j);
    }
}
