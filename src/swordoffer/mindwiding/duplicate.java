package swordoffer.mindwiding;

public class duplicate {
    public static void main(String[] args) {
        duplicate d = new duplicate();
        int[] res = new int[2];
        d.duplicate(new int[]{0,2,2,3,4,5},6,res);
        System.out.println(res[0]);
    }

    // O(n) solution
    public boolean duplicate(int numbers[],int length,int [] duplication) {
        if (null == numbers || length <= 0) {
            duplication[0] = -1;
            return false;
        }
        for (int i = 0; i < length; i++) {
            while (i != numbers[i]) {
                if (numbers[i] == numbers[numbers[i]]) {
                    duplication[0] = numbers[i];
                    return true;
                } else {
                    int tmp = numbers[numbers[i]];
                    numbers[numbers[i]] = numbers[i];
                    numbers[i] = tmp;
                }
            }
        }
        return false;
    }
}
