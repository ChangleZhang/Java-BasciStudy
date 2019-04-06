package leetcode;

public class leetcode125 {
    public static void main(String[] args)
    {
        String test = "1a2";
        System.out.println(isPalindrome(test));
    }

    public static boolean isPalindrome(String s) {
        char[] ch = s.toUpperCase().toCharArray();
        if (ch.length == 0 || ch.length == 1) {
            return true;
        }
        int l = 0, h = ch.length - 1;
        while (l < h){
            if (!isValid(ch[l])){
                l++;
                continue;
            }
            if (!isValid(ch[h])){
                h--;
                continue;
            }
            if (ch[l] != ch[h])
                return false;
            l++;
            h--;
        }
        return true;
    }

    public static boolean isValid(char c){
        if (c>='A' && c <='Z'){
            return true;
        }
        if (c>='0' && c <='9'){
            return true;
        }
        return false;
    }
}
