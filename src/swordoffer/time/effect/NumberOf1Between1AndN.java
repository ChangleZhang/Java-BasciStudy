package swordoffer.time.effect;

public class NumberOf1Between1AndN {

    public int NumberOf1Between1AndN_Solution(int n) {
        return NumberOfXBetween1AndN_Solution1(n,1);
    }
    public int NumberOfXBetween1AndN_Solution1(int n,int x) {
        if (n<0 || x<0 || x>9)
            return 0;
        int high, low, tmp, cur, i = 1;
        high = n;
        int total = 0;
        while (high != 0) {
            high = n / (int)Math.pow(10, i);
            tmp = n % (int)Math.pow(10, i);
            cur = n / (int)Math.pow(10, i-1);
            low = n % (int)Math.pow(10, i-1);
            if (cur == x) {
                total += high * Math.pow(10, i-1) + low + 1;
            } else if (cur < x){
                total += high * Math.pow(10, i-1);
            } else {
                total += (high+1) * Math.pow(10, i-1);
            }
        }
        return total;
    }
}
