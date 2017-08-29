package algorithm.dynamic_programming;

import java.util.Arrays;

/**
 * 最长非降子序列
 * Created by wangjianjun on 2017/8/28.
 */
public class LIS {

    public int getLIS(String A,int m){
        int []dp = new int[m];
        char[] arr = A.toCharArray();
        int length = 1;

        for (int i=0;i<m;i++)
            dp[i] = 1;

        for (int i=1;i<m;i++){
            for (int j=0;j<i;j++){
                if (arr[j]<=arr[i]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
                if (dp[i]>length){
                    length = dp[i];
                }
            }
        }

        System.out.println(Arrays.toString(dp));
        return length;
    }

    public static void main(String[] args) {
        System.out.println(new LIS().getLIS("324123",6));
    }
}
