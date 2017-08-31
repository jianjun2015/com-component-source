package algorithm.branch_bound_method;

/**
 * Created by wangjianjun on 2017/8/30.
 */
public class Backage0_1 {

    private Knapsack[] bags;//所有物品
    private int n;//物品的数量
    private int totalWeight;//背包总承重
    private int[][] bestValues;//第一维：当前第几个物品  第二维：当前背包承重
    private int bestValue;//最终背包最大价值

    public Backage0_1(Knapsack[] bags, int totalWeight){
        this.bags = bags;
        this.totalWeight = totalWeight;
        this.n = bags.length;
        if (this.bestValues == null)
            this.bestValues = new int[n+1][totalWeight+1];
    }

    public void solve(){
        for (int j=0;j<=totalWeight;j++){
            for (int i=0;i<=n;i++){
                if (i==0 || j==0)
                    bestValues[i][j] = 0;
                else {
                    // 如果第 i个物品重量大于总承重，则最优解存在于前 i-1 个背包中
                    if (j < bags[i-1].getWeight())
                        bestValues[i][j] = bestValues[i-1][j];
                    else {
                        // 如果第 i个物品不大于总承重，则最优解要么是包含第 i个背包的最优解，
                        // 要么是不包含第 i个背包的最优解， 取两者最大值
                        int weight = bags[i - 1].getWeight();
                        int value = bags[i - 1].getValue();
                        bestValues[i][j] = Math.max(bestValues[i - 1][j], value
                                + bestValues[i - 1][j - weight]);
                    }
                }
            }
        }

        bestValue = bestValues[n][totalWeight];
    }

    public int getBestValue(){
        return bestValue;
    }

    public static void main(String[] args) {

        Knapsack[] bags = new Knapsack[]{
                new Knapsack(1,10),
                new Knapsack(3,24),
                new Knapsack(2,15),
                new Knapsack(4,28),
                new Knapsack(5,33),
                new Knapsack(3,20),
                new Knapsack(1,8)
        };
        int totalWeight = 12;
        Backage0_1 backage0_1 = new Backage0_1(bags,totalWeight);

        backage0_1.solve();
        System.out.println(backage0_1.getBestValue());
    }
}
