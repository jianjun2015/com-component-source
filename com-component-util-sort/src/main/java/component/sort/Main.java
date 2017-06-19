package component.sort;

public class Main {

	public static void main(String[] args) {
		
		int arr[] = { 6, 5, 3, 1, 8, 7, 2, 4 }; 
		//BubbleSort.bubbleSort(arr);
		//BubbleSort.orderBubbleSort(arr);
//		SelectSort.selectSort(arr);
//		InsertSort.selectSort(arr);
//		QuickSort.sort(arr);
//		ShellSort.shellSort(arr);
		MergeSort.mergeSort(arr);
		
		printArr(arr);
	}
	
	public static void printArr(int[] arr){
		
		if(arr == null || arr.length == 0)
			return;
		for(int i=0;i<arr.length;i++)
			System.out.print(arr[i]+" ");
	}
}
