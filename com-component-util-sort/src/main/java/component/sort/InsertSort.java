package component.sort;

public class InsertSort {
	
	public static void selectSort(int[] arr){
		
		if(arr == null || arr.length == 0)
			return;
		
		for(int i=0;i<arr.length;i++){
			int j = i;
			int target = arr[i];
			while(j>0 && target < arr[j-1]){
				arr[j] = arr[j-1];
				j--;
			}
			arr[j] = target;
		}
	}

}
