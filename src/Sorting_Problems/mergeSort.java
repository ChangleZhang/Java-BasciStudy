package Sorting_Problems;

public class mergeSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {2,3,4,5,1,7,4,8,12};
	    mergeSort(arr,0,arr.length-1);
	    for(int i=0;i<arr.length;i++){
	    	System.out.print(arr[i]+" ");
	    }
	}
	
	public static void mergeSort(int[] array,int start,int end){
		if(start < end){
			int mid = (start + end)/2;
			//两路归并
			mergeSort(array,start,mid);
			mergeSort(array,mid+1,end);
			merge(array,start,mid,mid+1,end);
			
			//多路归并
			/*
			 * int mid = (start + end)/4;
			 * mergeSort(array,start,1*mid);
			 * mergeSort(array,1*mid+1,2*mid);
			 * mergeSort(array,2*mid+1,3*mid);
			 * mergeSort(array,3*mid+1,4*mid);
			 * merge(array,start,1*mid,1*mid+1,2*mid);
			 * merge(array,2*mid+1,3*mid,3*mid+1,end);
			 * merge(array,start,2*mid,2*mid+1,end);
			 */
		}
	}
	private static void  merge(int[] array,int start1,int end1,int start2, int end2){
		int i,j;//表示1和2的游标
		{
			i=start1;
			j=start2;
		}
		int k = 0;
		int[] tmp = new int[end2 - start1 +1];//临时存储数组
		
		while(i<=end1 && j<=end2){
			if(array[i]>array[j])
				tmp[k++]=array[j++];
			else
				tmp[k++]=array[i++];
		}
		while(i<=end1){
			tmp[k++] = array[i++];
		}
		while(j<=end2){
			tmp[k++] = array[j++];
		}
		k = start1;
		//将临时数组元素复制回到array中
		for(int element:tmp){
			array[k++] = element;
		}
	}
}