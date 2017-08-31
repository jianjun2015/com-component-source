package algorithm.divide_conquer;

/**
 * 归并排序
 * Created by wangjianjun on 2017/8/29.
 */
public class MergeSortCase {

    public static void main(String[] args) {
        int[] arr = {3,5,6,4,3,2,6,8};
        new MergeSortCase().mSort(arr,0,arr.length-1);
        for (int i=0;i<arr.length;i++)
            System.out.print(arr[i]);

        System.out.println();
    }

    //拆分递归处理
    public void mSort(int[]arr,int left,int right){
        if (left>=right)
            return;

        int mid = (left+right)/2;
        mSort(arr,left,mid);
        mSort(arr,mid+1,right);
        merge(arr,left,right);
    }

    //合并结果
    public void merge(int[]arr,int left,int right){

        //定义临时数组
        int[] tmp = new int[right-left+1];
        int mid = (left+right)/2;
        int i=left;
        int j=mid+1;
        int k=0;
        while (i<=mid && j<=right){
            if (arr[i]<=arr[j])
                tmp[k++] = arr[i++];
            else
                tmp[k++] = arr[j++];
        }

        //左边剩余元素
        while (i<=mid)
            tmp[k++] = arr[i++];

        //右边剩余元素
        while (j<=right)
            tmp[k++] = arr[j++];

        for (int p=0;p<tmp.length;p++){
            arr[left+p] = tmp[p];
        }
    }
}
