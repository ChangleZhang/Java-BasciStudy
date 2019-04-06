package swordoffer.time.effect;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class GetLeastNumbers {

    public static void main(String[] args) {
        int[] test0 = new int[]{1,2,3,4,5,6,7,8,9};
        ArrayList<Integer> res = GetLeastNumbers_Solution(test0, 3);
        System.out.println(res);
    }

    public static ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> res = new ArrayList<>();

        if(input==null || input.length<=0 || input.length<k || k==0){
            return res;
        }

        Queue<Integer> pQueue = new PriorityQueue<Integer>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        for (int i : input) {
            if (pQueue.size() == k) {
                if(pQueue.peek() > i) {
                    pQueue.poll();
                    pQueue.offer(i);
                }
            } else {
                pQueue.offer(i);
            }
        }
        for (int q : pQueue) {
            res.add(q);
        }
        return res;
    }
}
