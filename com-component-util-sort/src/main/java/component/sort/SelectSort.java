package component.sort;

import component.util.Exchange;

public class SelectSort {
	
	public static void selectSort(int[] arr){
		
		if(arr == null || arr.length == 0)
			return;
		
		int minIndex = 0;
		for(int i=0;i<arr.length-1;i++){
			minIndex = i;
			for(int j=i+1;j<arr.length;j++){
				if(arr[minIndex]>arr[j]){
					minIndex = j;
				}
			}
			if (minIndex != i)
				Exchange.swap(arr, i, minIndex);
		}
			
	}

}
