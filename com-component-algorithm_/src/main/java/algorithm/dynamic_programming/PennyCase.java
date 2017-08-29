package algorithm.dynamic_programming;

/**
 * Created by wangjianjun on 2017/8/23.
 */
public class PennyCase {

    public int countWays(int[] penny,int n,int aim){

        if (n == 0 || penny == null || aim < 0){
            return 0;
        }

        int [][]pd = new int[n][aim+1];
        for (int i=0;i<n;i++){
            pd[i][0] = 1;
        }
        for (int i=1;penny[0]*i<=aim;i++){
            pd[0][penny[0]*i] = 1;
        }
        for (int i=1;i<n;i++){
            for (int j=0;j<=aim;j++){
                if (j>=penny[i]){
                    pd[i][j] = pd[i-1][j]+pd[i][j-penny[i]];
                }else {
                    pd[i][j] = pd[i-1][j];
                }
            }
        }
        return pd[n-1][aim];
    }

    public static void main(String[] args) {
        int[] penny = new int[]{2,3,5};
        int n = 3;
        int aim = 9;
        System.out.println(new PennyCase().countWays(penny,n,aim));
    }
}
