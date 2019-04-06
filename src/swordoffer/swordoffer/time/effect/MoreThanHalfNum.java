package swordoffer.time.effect;

public class MoreThanHalfNum {
    /**
     * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
     */
    public static void main(String[] args) {
        int[] test0 = new int[]{};
        int[] test1 = new int[]{0};
        int[] test2 = new int[]{0,1,1,1};
        int[] test3 = new int[]{0,1,3,3,3,3,3,1,0};
        System.out.println(MoreThanHalfNum_Solution(test0));
        System.out.println(MoreThanHalfNum_Solution(test1));
        System.out.println(MoreThanHalfNum_Solution(test2));
        System.out.println(MoreThanHalfNum_Solution(test3));
    }

    public static int MoreThanHalfNum_Solution(int [] array) {
        if (0 == array.length)
            return 0;

        int idx = 0;
        int curNum = array[idx++];
        int cnt = 1;
        while (idx < array.length) {
            if (cnt == 0) {
                curNum = array[idx++];
                cnt ++;
            } else {
                if (array[idx++] != curNum) {
                    cnt --;
                } else {
                    cnt ++;
                }
            }
        }
        return curNum;
    }
}
