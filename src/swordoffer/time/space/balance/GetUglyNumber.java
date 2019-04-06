package swordoffer.time.space.balance;

public class GetUglyNumber {

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
