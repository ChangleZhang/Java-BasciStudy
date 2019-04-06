package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leetcode345 {
    public static void main(String[] args) {
        String test = "ai";
        System.out.println(reverseVowels(test));
    }

    public static String reverseVowels(String s) {
        List<Character> ls = Arrays.asList('A','E','I','O','U','a','e','i','o','u');
        if (s.length() == 0){
            return s;
        }
        char[] ch = s.toCharArray();
        int l = 0;
        int h = ch.length - 1;
        while (l < h) {
            if (!isVowel(ch[l],ls)){
                l++;
                continue;
            }
            if (!isVowel(ch[h],ls)){
                h--;
                continue;
            }
            swap(ch,l,h);
            l++;
            h--;
        }
        return String.valueOf(ch);
    }

    private static boolean isVowel(char c, List<Character> ls){
        return ls.contains(c);
    }

    private static void swap(char[] ch, int i, int j){
        char buff = ch[i];
        ch[i] = ch[j];
        ch[j] = buff;
    }
}
