package algorithm.divide_conquer;

/**
 * 最大子序列
 * 问题描述
 输入一组整数，求出这组数字子序列和中最大值。也就是只要求出最大子序列的和，不必求出最大的那个序列。例如：
 序列：-2 11 -4 13 -5 -2，则最大子序列和为20。
 * Created by wangjianjun on 2017/8/29.
 */
public class MaxSubSeqSumCase {

    public static void main(String[] args) {
        int[] arr = {2,-3,4,2,-5,8,7,-4,9,5};
        System.out.println(new MaxSubSeqSumCase().getMaxSubSeqSum(arr,0,arr.length-1));
    }

    public int getMaxSubSeqSum(int[] arr,int left,int right){

        return maxSumRec(arr,left,right);
    }

    public int maxSumRec(int[] arr,int left,int right){

        if (left == right) {
            if (arr[left] > 0)
                return arr[left];
            else
                return 0;
        }

        int mid = (left+right)/2;
        int maxLeftSum = maxSumRec(arr,left,mid);
        int maxRightSum = maxSumRec(arr,mid+1,right);
        int maxLeftBorderSum = 0,leftBorderSum = 0;
        for (int i=mid;i>=left;i--){
            leftBorderSum +=arr[i];
            if (leftBorderSum>maxLeftBorderSum)
                maxLeftBorderSum=leftBorderSum;
        }
        int maxRightBorderSum = 0,rightBorderSum = 0;
        for (int j=mid+1;j<=right;j++){
            rightBorderSum +=arr[j];
            if (rightBorderSum>maxRightBorderSum)
                maxRightBorderSum = rightBorderSum;
        }

        return max(maxLeftSum,maxRightSum,maxLeftBorderSum+maxRightBorderSum);
    }

    public int max(int a,int b,int c){
        return a>b?(a>c?a:c):(b>c?b:c);
    }
}
