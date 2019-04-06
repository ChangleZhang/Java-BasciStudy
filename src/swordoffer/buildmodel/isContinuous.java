package swordoffer.buildmodel;

public class isContinuous {
    public static void main(String[] args) {
        System.out.println(isContinuous(new int[]{1,2,3,5,0}));
    }

    public static boolean isContinuous(int [] numbers) {
        // not empty
        if (null == numbers || numbers.length==0)
            return false;
        // map finding
        int[] hmap = new int[14];
        for (int i : numbers) {
            hmap[i] +=1;
        }
        int start=14,end = 0;
        // double
        for (int i=1;i<14;i++) {
            if (hmap[i] == 1) {
                if (i<start)
                    start = i;
                if (i > end)
                    end = i;
            }
            if(hmap[i]>1)
                return false;
        }
        if (end - start > 4)
            return false;
        return true;
    }
}
