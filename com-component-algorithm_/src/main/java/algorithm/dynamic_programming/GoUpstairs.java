package algorithm.dynamic_programming;

/**
 * 有n级台阶，一个人每次上一级或者两级，问有多少种走完n级台阶的方法。为了防止溢出，请将结果Mod 1000000007
 给定一个正整数int n，请返回一个数，代表上楼的方式数。保证n小于等于100000。
 测试样例：
 1
 返回：1
 * Created by wangjianjun on 2017/8/28.
 */
public class GoUpstairs {

    public int countWays(int n){
        if (n<=2)
            return n;

        int f = 1%1000000007;
        int s = 2%1000000007;
        int t = 0;

        //f(n) = f(n-1) + f(n-2)
        for (int i=3;i<=n;i++){
            t = (f+s)%1000000007;
            f = s;
            s = t;
        }

        return t;
    }

    /**
     * 递归解决(fibonacci算法)
     * @param n
     * @return
     */
    public int countWays_(int n){
        if (n <= 2)
            return n;
        else
            return countWays_(n-1)+countWays_(n-2);
    }

    public static void main(String[] args) {
        System.out.println(new GoUpstairs().countWays(4));
        System.out.println(new GoUpstairs().countWays_(4));
    }
}
