package component.sort;

public class ShellSort {
	
	public static void shellSort(int[] arr){
		
		if(arr == null || arr.length == 0)
			return;
		
		int d = arr.length/2;
		while(d>=1){
			shellInsert(arr,d);
			d/=2;
		}
	}
	
	public static void shellInsert(int[] arr,int d){
		
		for(int i=d;i<arr.length;i++){
			int j = i-d;
			int temp = arr[i];
			while(j>=0 && arr[j]>temp){
				arr[j+d] = arr[j];
				j -= d;
			}
			
			if(j != i-d)
				arr[j+d] = temp;
		}
	}

}
