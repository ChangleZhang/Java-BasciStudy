package swordoffer.time.space.balance;

public class FirstNotRepeatingChar {
    /**
     * 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置, 如果没有则返回 -1（需要区分大小写）
     */
    public static void main(String[] args) {
        System.out.println(FirstNotRepeatingChar_Solution("aavvcbb"));
    }

    public static int FirstNotRepeatingChar_Solution(String str) {
        int[] hashMap = new int[256];
        for (char c : str.toCharArray()) {
            hashMap[c] ++;
        }
        for (int i=0; i<str.length(); i++) {
            if (hashMap[str.charAt(i)] == 1) {
                return i;
            }
        }
        return -1;
    }
}
