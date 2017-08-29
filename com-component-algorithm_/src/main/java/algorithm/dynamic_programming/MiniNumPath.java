package algorithm.dynamic_programming;

/**
 * 有一个矩阵map，它每个格子有一个权值。从左上角的格子开始每次只能向右或者向下走，最后到达右下角的位置，路径上所有的数字累加起来就是路径和，返回所有的路径中最小的路径和。
 给定一个矩阵map及它的行数n和列数m，请返回最小路径和。保证行列数均小于等于100.
 测试样例：
 [[1,2,3],[1,1,1]],2,3
 返回：4
 * Created by wangjianjun on 2017/8/28.
 */
public class MiniNumPath {

    public int getMin(int[][] map,int n,int m){

        int[][] dp = new int[n][m];
        //得到第一列：从第一行到最后一行的每个路径长度
        for (int i=0;i<n;i++){
            for (int j=0;j<=i;j++){
                dp[i][0]+=map[j][0];
            }
        }
        //得到第一行：从第一列到最后一列每个节点的路径长度
        for (int i=0;i<m;i++){
            for (int j=0;j<=i;j++){
                dp[0][i] += map[0][j];
            }
        }

        //i,j 均从第二个节点开始来判断，都是当前结点加上上面节点[左边节点]--取小的即为第一个节点到当前结点路径小的长度
        for (int i=1;i<n;i++){
            for (int j=1;j<m;j++){
                dp[i][j] = min(dp[i][j-1]+map[i][j],dp[i-1][j]+map[i][j]);
            }
        }

        //返回路径最小数
        return dp[n-1][m-1];
    }

    /**
     * 两个取小
     * @param a
     * @param b
     * @return
     */
    public int min(int a,int b){
        return a>b?b:a;
    }

    public static void main(String[] args) {
        int[][] dp = {{1,2,3},{1,1,1}};
        int result = new MiniNumPath().getMin(dp,2,3);
        System.out.println(result);
    }
}
