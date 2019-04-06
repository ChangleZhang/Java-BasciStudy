package swordoffer.buildmodel;

public class ngetouzi {
    public static void main(String[] args) {
        print(6,4);
    }

    private static void print(int maxValue, int n) {
        int[][] a = new int[2][];
        a[0] = new int[n*maxValue + 1];
        a[1] = new int[n*maxValue + 1];
        int flag = 0;
        int j,k;
        // Initialization
        for (int i=0; i<n*maxValue + 1; i++) {
            a[0][i] = 0;
            a[1][i] = 0;
        }
        for (int i=1; i<=maxValue; i++) {
            a[flag][i] = 1;
        }
        for (k=2; k<= n; k++) { // loop of touzi
            // clear 0-k touzi
            for (int i=0; i<k; i++) {
                a[1-flag][i] = 0;
            }
            for (int i=k;i<=k*maxValue;i++) {
                a[1-flag][i] = 0;
                for (j=1;j<=i&&j<=maxValue;j++)
                    a[1-flag][i] += a[flag][i-j];
            }
            // reverse flag
            flag = 1 - flag;
        }
        // after all, calculate rate
        double total = Math.pow(maxValue, 2);
        for (int i=0;i<n*maxValue+1; i++) {
            System.out.println(a[flag][i]/ total);
        }
    }
}
