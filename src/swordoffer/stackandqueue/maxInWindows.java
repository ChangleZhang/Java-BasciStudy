package swordoffer.stackandqueue;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class maxInWindows {
    public static void main(String[] args) {
        System.out.println(maxInWindows(new int[]{2,3,4,2,6,2,5,1}, 3));
    }
    public static ArrayList<Integer> maxInWindows(int [] num, int size) {
        ArrayList<Integer> res = new ArrayList<>();
        if (null == num || num.length <1 || size <1)
            return res;
        int begin;
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        for (int i=0; i<num.length; i++) {
            begin = i - size + 1;
            if (deque.isEmpty()) {
                deque.add(i);
            } else if (begin > deque.peekFirst()){
                deque.pollFirst();
            }
            while (!deque.isEmpty() && num[i] >= num[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.add(i);
            if (begin >= 0) {
                res.add(num[deque.peekFirst()]);
            }
        }
        return res;
    }
}
