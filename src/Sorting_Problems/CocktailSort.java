package Sorting_Problems;

public class CocktailSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int[] ints = {2,3,4,5,1,7,4,8,12};
	     cocktailSort(ints);
	     for(int i=0;i<ints.length;i++){
	    	 System.out.print(ints[i]+" ");
	     }
	}

	public static void cocktailSort(int[] cints){
      //将最小值排到队尾
      for (int i = 0 ; i < cints.length; i++){
          for (int j = 0; j <cints.length-i-1 ; j++) {
              if (cints[j] > cints[j+1]){
                  int temp = cints[j];
                  cints[j] = cints[j+1];
                  cints[j+1] = temp;
              }
          }
          //将最大值排到队头
          for(int j = cints.length-1-(i+1); j > i ; j--)
          {
              if(cints[j] > cints[j-1])
              {
                  int temp = cints[j];
                  cints[j] = cints[j-1];
                  cints[j-1] = temp;
              }
              
          }
      }
    }
}
