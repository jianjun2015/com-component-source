package component.sort;

import component.util.Exchange;

/**
 * 冒泡排序
 * @author wangjianjun
 *
 */
public class BubbleSort {

	public static void bubbleSort(int[] arr){

		if(arr == null || arr.length == 0)
			return;

		int count=0;

//		for(int j=0;j<arr.length-1;j++){
//			for(int i=j;i<arr.length;i++){
//				if(arr[i]<arr[j]){
//				Exchange.swap(arr, i, j);
//				count++;
//				}
//			}
//		}

		for (int j = 0; j < arr.length - 1; j++)            // 每次最大元素就像气泡一样"浮"到数组的最后
		{
			for (int i = 0; i < arr.length - 1 - j; i++)    // 依次比较相邻的两个元素,使较大的那个向后移
			{
				if (arr[i] > arr[i + 1])            // 如果条件改成A[i] >= A[i + 1],则变为不稳定的排序算法
				{
					Exchange.swap(arr, i, i + 1);
					count++;
				}
			}
		}
		System.out.println("count:"+count);
	}

	/**
	 * 定向冒泡排序
	 * @param arr
	 */
	public static void orderBubbleSort(int[] arr){

		if(arr == null || arr.length == 0)
			return;

		int count=0;
		int left = 0;
		int right = arr.length-1;

		while(left<right){
			for(int i=left;i<right;i++){
				if(arr[i]>arr[i+1]){
					Exchange.swap(arr, i, i+1);
					count++;
				}

			}
			right--;
			for(int i=right;i>left;i--){
				if(arr[i--]>arr[i]){
					Exchange.swap(arr, i-1, i);
					count++;
				}
			}
			left++;

		}

		System.out.println("count:"+count);
	}

}

