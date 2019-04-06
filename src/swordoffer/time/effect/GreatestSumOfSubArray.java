package swordoffer.time.effect;

public class GreatestSumOfSubArray {
    public static void main(String[] args) {
        int[] test0 = new int[]{6,-3,-2,7,-15,1,2,2};
        System.out.println("test 0 = " + FindGreatestSumOfSubArray(test0));
        System.out.println(FindGreatestSumOfSubArray(null));
    }

    public static int FindGreatestSumOfSubArray(int[] array) {
        if (null == array || 0 == array.length) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int cur = 0;
        for (int i=0 ; i< array.length; i++) {
            if (cur < 0) {
                cur = array[i];
            } else {
                cur = cur + array[i];
            }
            if (cur > max)
                max = cur;
        }
        return max;
    }
}
