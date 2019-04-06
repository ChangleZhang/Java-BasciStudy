package swordoffer.time.effect;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PrintMinNumber {

    public static void main(String[] args) {
        int[] test0 = new int[]{3,32,321};
        System.out.println(PrintMinNumber_Solution(test0));
    }

    public static String PrintMinNumber_Solution(int [] numbers){
        StringBuilder sb = new StringBuilder();
        List<String> ls = new ArrayList<>();
        for (int i : numbers) {
            ls.add(String.valueOf(i));
        }
        Collections.sort(ls, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String str1 = o1 + o2;
                String str2 = o2 + o1;
                return str1.compareTo(str2);
            }
        });
        for (String s : ls) {
            sb.append(s);
        }
        return sb.toString();
    }
}
