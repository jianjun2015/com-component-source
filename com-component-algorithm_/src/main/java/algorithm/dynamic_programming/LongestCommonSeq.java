package algorithm.dynamic_programming;

/**
 * 最长公共序列数
 给定两个字符串A和B，返回两个字符串的最长公共子序列的长度。例如，A="1A2C3D4B56”，B="B1D23CA45B6A”，”123456"或者"12C4B6"都是最长公共子序列。
 给定两个字符串A和B，同时给定两个串的长度n和m，请返回最长公共子序列的长度。保证两串长度均小于等于300。
 测试样例：
 "1A2C3D4B56",10,"B1D23CA45B6A",12
 返回：6
 * Created by wangjianjun on 2017/8/28.
 */
public class LongestCommonSeq {

    public int findLCS(String A,int n,String B,int m){
        int [][] dp = new int[n][m];
        char[] arrayA = A.toCharArray();
        char[] arrayB = B.toCharArray();

        //找出数组A中第一个与数组B[0]相等的字符，如找到并将其后的都置为1
        for (int i=0;i<n;i++){
            if (arrayA[i] == arrayB[0]){
                dp[i][0] = 1;
                for (int j=i+1;j<n;j++){
                    dp[j][0] = 1;
                }
                break;
            }
        }

        //找出数组B中第一个与数组A[0]相等的字符位置，如找到并将其后的都置为1
        for (int i=0;i<m;i++){
            if (arrayA[0] == arrayB[i]){
                dp[0][i] = 1;
                for (int j=i+1;j<m;j++){
                    dp[0][j] = 1;
                }
                break;
            }
        }

        //A[i] == B[j] --> 当前的最长子序列为上一层+1、当前上面、当前的左边中取最大值
        for (int i=1;i<n;i++){
            for (int j=1;j<m;j++){
                if (arrayA[i] == arrayB[j]){
                    dp[i][j] = max(dp[i-1][j-1]+1,dp[i-1][j],dp[i][j-1]);
                }else {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }

        for (int i=0;i<n;i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("##############################");

        return dp[n-1][m-1];
    }

    /**
     * 三个数取最大数
     * @param a
     * @param b
     * @param c
     * @return
     */
    public int max(int a,int b,int c){
        int max = a;

        if (max < b)
            max = b;

        if (max < c)
            max = c;

        return max;
    }

    public static void main(String[] args) {
        System.out.println(new LongestCommonSeq().findLCS("1A2C3D",6,"B1D23",5));
    }
}
