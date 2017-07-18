package component.math;

/**
 * Created by wangjianjun on 2017/7/18.
 */
public class Fibonacci {

    public static void main(String[] args) {
        for (int i=0;i<20;i++){
            System.out.println(fibonacci(i));
        }
    }

    public static long fibonacci(int n){
        if (n < 1){
            return 0;
        }else if (n == 1 || n==2){
            return 1;
        }else {
            return fibonacci(n-1)+fibonacci(n-2);
        }
    }
}
