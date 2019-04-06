package leetcode;

import java.util.ArrayList;
import java.util.List;

public class leetcode438 {
    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
        System.out.println(findAnagrams(s,p));
    }

    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int l =0, h = 0, count = p.length();
        int[] hash = new int[256];
        char[] ch = p.toCharArray();
        for (char c : ch){
            hash[c] ++;
        }
        while (h < s.length()){
            if (--hash[s.charAt(h++)] >= 0)
                count--;
            if (count == 0)
                res.add(l);
            if(h - l == p.length() && hash[s.charAt(l++)]++>=0)
                count ++;
        }
        return res;
    }
}
