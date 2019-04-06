package swordoffer.time.space.balance;

public class GetUglyNumber {
    /**
     * 把只包含质因子2、3和5的数称作丑数（Ugly Number）。例如6、8都是丑数，但14不是，因为它包含质因子7。
     * 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
     */

    public static void main(String[] args) {
        System.out.println(GetUglyNumber_Solution(8));
    }

    public static int GetUglyNumber_Solution(int index) {
        if (index < 7)
            return index;
        int[] tmp = new int[index];
        tmp[0] = 1;
        int t2 = 0;
        int t3 = 0;
        int t5 = 0;
        for (int i=1; i<index; i++) {
            tmp[i] = Math.min(tmp[t2]*2, Math.min(tmp[t3]*3, tmp[t5]*5));
            if (tmp[i] == tmp[t2] * 2) t2 ++;
            if (tmp[i] == tmp[t3] * 3) t3 ++;
            if (tmp[i] == tmp[t5] * 5) t5 ++;
        }
        return tmp[index-1];
    }
}
