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
		
		//�Ż�
//		int pivotKey = arr[left];
//        
//        while(left < right) {
//            while(left < right && arr[right] >= pivotKey)
//                right --;
//            arr[left] = arr[right]; //��С���ƶ������
//            while(left < right && arr[left] <= pivotKey)
//                left ++;
//            arr[right] = arr[left]; //�Ѵ���ƶ����ұ�
//        }
//        arr[left] = pivotKey; //����pivot��ֵ���м�
//        return left;
	}
	
}
