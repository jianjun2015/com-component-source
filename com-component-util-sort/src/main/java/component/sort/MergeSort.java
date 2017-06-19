package component.sort;

public class MergeSort {
	
	public static void mergeSort(int[] arr){
		if(arr == null || arr.length == 0)
			return;
		
		mSort(arr, 0, arr.length-1);
	}
	
	public static void mSort(int[] arr,int left,int right){
		if(left >=right)
			return;
		
		int mid = (left+right)/2;
		mSort(arr, left, mid);
		mSort(arr, mid+1, right);
		merge(arr, left, mid, right);
	}
	
	public static void merge(int[] arr,int left,int mid,int right){
		int[] temp = new int[right-left+1];
		
		int i=left;
		int j=mid+1;
		int k=0;
		while(i<=mid && j<=right){
			if(arr[i]<=arr[j]){
				temp[k++] = arr[i++];
			}else{
				temp[k++] = arr[j++];
			}
		}
		
		while(i <= mid){
			temp[k++] = arr[i++];
		}
		
		while(j<=right){
			temp[k++] = arr[j++];
		}
		
		for(int p=0;p<temp.length;p++){
			arr[left+p] = temp[p];
		}
	}

}
