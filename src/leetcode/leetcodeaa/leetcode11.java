package leetcode;

public class leetcode11 {
    public static void main(String[] args) {
        int[] height = new int[]{1,2,4,3};
        System.out.println(maxArea(height));
    }

    private static int maxArea(int[] height) {
        int l = 0;
        int h = height.length - 1;
        int max = -1;
        while (l < h){
            max = Math.max(max, Math.min(height[l],height[h]) * (h-l));
            if (height[l] < height[h]){
                l++;
            }else{
                h --;
            }
        }
        return max;
    }
}
