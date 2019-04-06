package swordoffer.buildmodel;

public class LastRemaining_Solution {
    public static void main(String[] args) {
        System.out.println();
    }

    // simple use list
    public static int LastRemaining_Solution_Aplha(int n, int m) {
        return 0;
    }
    // use : f(n,m) = 0 if n=0;[f(n-1,m) + m] % n  if n>0
    public int LastRemaining_Solution_Beta(int n, int m) {
        if (n<1 || m<1)
            return -1;
        int last = 0;
        for (int i=2; i<=n;i++) {
            last = (last + m) %i;
        }
        return last;
    }
}
