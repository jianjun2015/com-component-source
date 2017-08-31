package algorithm.branch_bound_method;

/**
 * Created by wangjianjun on 2017/8/30.
 */
public class Knapsack {

    private int weight;
    private int value;

    public Knapsack(int weight, int value) {
        this.weight = weight;
        this.value = value;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
