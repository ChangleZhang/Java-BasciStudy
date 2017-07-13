package Sorting_Problems;

public class selectSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] ints = {2,3,4,5,1,7,4,8,12};
	    selectSort(ints);
	    for(int i=0;i<ints.length;i++){
	    	System.out.print(ints[i]+" ");
	    }
	}

	public static void selectSort(int[] arr){
		for(int i=0;i<arr.length;i++){
			for(int j=i; (j>0) && (arr[j]<arr[j-1]);j--){
				swap(arr,j,j-1);
			}
		}
	}
	
	private static void swap(int[] arr, int i, int j){
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
}
