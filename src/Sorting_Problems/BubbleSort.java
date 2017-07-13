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
	 * ��������֮ǰ����һ�㲻ͬ��ά����һ��������״̬���������ڽ�����ʱ�������ĳ�ο�ʼû�в���Ԫ�ؽ�������֤�������ʱ�̿�ʼ��
	 * �Ѿ�����Ҫ�ٽ����ˣ���ʱ��Ϳ��Լ���û���õı�������
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