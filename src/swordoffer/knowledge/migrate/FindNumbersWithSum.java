package swordoffer.knowledge.migrate;

import java.util.ArrayList;

public class FindNumbersWithSum {

    public static void main(String[] args) {

    }

    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        ArrayList<Integer> res = new ArrayList<>();
        if (null == array)
            return res;
        int start = 0;
        int end = array.length - 1;
        while (start < end) {
            if (array[start] + array[end] == sum) {
                res.add(array[start]);
                res.add(array[end]);
                break;
            } else if (array[start] + array[end] > sum) {
                end --;
            } else {
                start ++;
            }
        }
        return res;
    }
}
