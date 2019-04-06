package leetcode;

public class leetcode76 {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(minWindow(s,t));
    }

    public static String minWindow(String s, String t) {
        int len = s.length() + 1;
        int l =0, start = 0, num = t.length();
        char[] ch = s.toCharArray();
        int[] hash = new int[256];
        for (char c : t.toCharArray())
            hash[c]++;
        for (int i=0; i< s.length(); i++){
            if (hash[ch[i]]-->0)
                num--;
            while (num == 0){
                if ((i - l + 1)<len){
                    start = l;
                    len = i - start + 1;
                }
                if (hash[ch[l++]]++ == 0)
                    num ++;
            }
        }
        return len == s.length()+1?"":s.substring(start,start + len);
    }
}
