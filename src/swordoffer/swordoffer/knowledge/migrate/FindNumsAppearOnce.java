package swordoffer.knowledge.migrate;

public class FindNumsAppearOnce {
    /**
     * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
     */
    public static void main(String[] args) {
        int[] res1 = new int[1];
        int[] res2 = new int[1];
        int[] test = new int[]{1,2,2,3,3,4,4,5,5,6};
        FindNumsAppearOnce_Solution(test, res1, res2);
        System.out.println("res1 = " + res1[0] + " res2= " + res2[0]);
    }

    public static void FindNumsAppearOnce_Solution(int [] array,int num1[] , int num2[]) {
        if (null == array || array.length < 2)
            return;

        int xor = 0;
        for (int n : array) {
            xor = xor ^ n;
        }

        int index = findLast1(xor);
        int n1 = 0;
        int n2 = 0;
        for (int n : array) {
            if (isIdx1(n, index)) {
                n1 = n1 ^ n;
            } else {
                n2 = n2 ^ n;
            }
        }
        num1[0] = n1;
        num2[0] = n2;
    }

    private static int findLast1(int n) {
        int i = 0;
        while (n > 0) {
            if ((n & 1) == 1)
                return i;
            n = n >> 1;
            i++;
        }
        return 0;
    }

    private static boolean isIdx1 (int num, int idx) {
        return ((num >> idx) & 1) == 1;
    }
}
