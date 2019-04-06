package swordoffer.time.effect;

public class NumberOf1Between1AndN {
    /**
     * 求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？为此他特别数了一下1~13中包含1的数字有
     * 1、10、11、12、13因此共出现6次,但是对于后面问题他就没辙了。ACMer希望你们帮帮他,并把问题更加普遍化,
     * 可以很快的求出任意非负整数区间中1出现的次数（从1 到 n 中1出现的次数）。
     */
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
            high = n / (int)Math.pow(10, i); // 第i位的高位
            tmp = n % (int)Math.pow(10, i); // 第i位至最低位
            cur = n / (int)Math.pow(10, i-1);// 当前为值
            low = n % (int)Math.pow(10, i-1);// 第i位的低位
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
