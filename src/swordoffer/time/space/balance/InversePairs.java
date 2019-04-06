package swordoffer.time.space.balance;

import java.util.Arrays;

public class InversePairs {

    public static void main(String[] args) {
        int[] test0 = new int[]{7,5,6,4};
        System.out.println(InversePairs_Solution(test0));
    }

    public static int InversePairs_Solution(int [] array) {
        if (null == array || array.length == 0)
            return 0;

        int[] copy = Arrays.copyOf(array, array.length);

        return InversePairsCore(array, copy, 0, array.length-1);
    }

    public static int InversePairsCore(int[] array, int[] copy, int low, int high) {
        if (low == high)
            return 0;
        int mid = (high + low) >> 1;
        int leftCount = InversePairsCore(array, copy, low, mid);
        int rightCount = InversePairsCore(array, copy, mid+1, high);


        int count = 0;
        int i = mid;
        int j = high;
        int loc = high;
        while (i>=low && j >=mid+1) {
            if(array[i] > array[j]) {
                count += j - mid;
                copy[loc--] = array[i--];
                if(count>=1000000007)
                {
                    count%=1000000007;
                }
            } else {
                copy[loc--] = array[j--];
            }
        }
        while(i>=low) {
            copy[loc--] = array[i--];
        }
        while(j>=mid+1) {
            copy[loc--] = array[j--];
        }
        for (int s=low; s<=high; s++) {
            array[s] = copy[s];
        }
        return (leftCount + rightCount + count) % 1000000007;
    }
}
