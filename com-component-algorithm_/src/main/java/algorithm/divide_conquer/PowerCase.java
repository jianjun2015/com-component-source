package algorithm.divide_conquer;

/**
 * 求x的n次幂：拆分子问题、递归求解
 * Created by wangjianjun on 2017/8/29.
 */
public class PowerCase {

    public int power(int x,int n){
        if (n == 1)
            return x;

        if (n % 2 == 0){
            return power(x,n/2)*power(x,n/2);
        }else {
            return power(x,(n+1)/2)*(power(x,(n-1)/2));
        }
    }

    public static void main(String[] args) {
        int x = 3;
        int n = 5;
        System.out.println(new PowerCase().power(x,n));
    }
}
