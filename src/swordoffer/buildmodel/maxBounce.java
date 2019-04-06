package swordoffer.buildmodel;

public class maxBounce {
    public static void main(String[] args) {
        System.out.println(maxBounce_Solution(new int[]{1,2,3,4,5}));
        System.out.println(maxBounce_Solution(new int[]{2,2,3,4,5}));
        System.out.println(maxBounce_Solution(new int[]{2,7,3,4,5}));
    }

    public static int maxBounce_Solution(int[] priceArray) {
        int[] resArray = new int[priceArray.length];
        if(priceArray.length <=1)
            return 0;
        int min = priceArray[0];
        int max = 0;
        for (int i=0;i<priceArray.length; i++) {
            int curIncom = priceArray[i] - min;
            if (curIncom > max)
                max = curIncom;
            if(priceArray[i] <min)
                min=priceArray[i];
        }
        return max;
    }
}
