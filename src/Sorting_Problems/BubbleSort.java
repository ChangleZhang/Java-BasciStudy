package Sorting_Problems;

public class BubbleSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = new int[]{3,2,1,6,5,4,9,8,7};
		bubble_sort(a);
		for(int i=0;i<a.length;i++){
			System.out.print(a[i]+" ");
		}
	}

	private static void bubble_sort(int[] arr){
		for(int i = arr.length-1;i>0;i--){
			for(int j=0;j<i;j++){
				if(arr[j]>arr[j+1])
					swap(arr,j,j+1);
			}
		}
	}
	
	private static void swap(int[] arr, int i, int j){
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
	/**
	 * 个方法和之前的有一点不同，维护了一个布尔型状态变量，即在交换的时候，如果从某次开始没有产生元素交换，就证明从这个时刻开始，
	 * 已经不需要再交换了，这时候就可以减少没有用的遍历次数
	 */
	private static void bubble_sort2(int[] arr){
		boolean exchange;
		for(int i = arr.length-1;i>0;i--){
			exchange = false;
			for(int j=0;j<i;j++){
				if(arr[j]>arr[j+1]){
					swap(arr,j,j+1);
					exchange = true;
				}
			}
			if(!exchange)
				return;
		}
	}
}