package leetcode;

public class leetcode3 {
    public static void main(String[] args) {
        String test = "a";
        System.out.println(lengthOfLongestSubstring(test));
    }
    public static int lengthOfLongestSubstring(String s) {
        char[] ch = s.toCharArray();
        if (ch.length == 0){
            return 0;
        }
        int[] time = new int[256];
        int l=0;
        int h=0;
        int max = 1;
        time[ch[h]]=1;
        while (h < ch.length-1){
            if (time[ch[h+1]] == 0){
                time[ch[++h]]++;
                max = Math.max(max, h-l+1);
            } else {
                time[ch[l++]]--;
            }
        }
        return max;
    }
}
