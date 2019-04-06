package swordoffer.time.space.balance;

import java.util.Arrays;

public class InversePairs {
    /**
     * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
     * 输入一个数组,求出这个数组中的逆序对的总数P。
     * 并将P对1000000007取模的结果输出。 即输出P%1000000007
     */
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

        // 归并计数过程
        int count = 0;
        int i = mid;
        int j = high;
        int loc = high;
        while (i>=low && j >=mid+1) {
            if(array[i] > array[j]) {
                count += j - mid;
                copy[loc--] = array[i--];
                if(count>=1000000007)//数值过大求余
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
