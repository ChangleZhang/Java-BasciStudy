package swordoffer.mindwiding;

public class sumwithoutoperator {
    public static void main(String[] args) {
        sumwithoutoperator s = new sumwithoutoperator();
        System.out.println(s.Sum_Solution(5));
    }
    // use recursive
    public int Sum_Solution(int n) {
        int sum = n;
        boolean flag = (n > 0) && ((sum+=Sum_Solution(n-1)) >0);
        return sum;
    }
}
