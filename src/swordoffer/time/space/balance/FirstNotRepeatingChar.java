package swordoffer.time.space.balance;

public class FirstNotRepeatingChar {

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
