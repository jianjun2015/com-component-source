package component.sort;

import component.util.Exchange;

public class QuickSort {

	public static void sort(int[] arr){
		
		if(arr == null || arr.length == 0)
			return;
		
		quickSort(arr,0,arr.length-1);
	}
	
public static void quickSort(int[] arr,int left,int right){
		
		while(left >= right)
			return;
		
		int pivotPos = partition(arr, left, right);
		quickSort(arr, left, pivotPos-1);
		quickSort(arr, pivotPos+1, right);
		
	}
	
	public static int partition(int[] arr,int left,int right){
			
		int pivotKey = arr[left];
		int pivotPointer = left;
		while(left < right){
			while(left<right && arr[right]>=pivotKey)
				right--;
			while(left<right && arr[left]<=pivotKey)
				left++;
			Exchange.swap(arr, left, right);
		}
		
		Exchange.swap(arr, pivotPointer, left);
		return left;

//		int pivot = arr[left];     //枢轴记录
//		while (left<right){
//			while (left<right && arr[right]>=pivot)
//				--right;
//			arr[left]=arr[right];             //交换比枢轴小的记录到左端
//			while (left<right && arr[left]<=pivot)
//				++left;
//			arr[right] = arr[left];           //交换比枢轴小的记录到右端
//		}
//		//扫描完成，枢轴到位
//		arr[left] = pivot;
//		//返回的是枢轴的位置
//		return left;
	}

	public static void main(String[] args) {
		int[] arr = new int[]{3,2,5,7,9,4};
		sort(arr);
		System.out.println(arr);
	}
	
}
