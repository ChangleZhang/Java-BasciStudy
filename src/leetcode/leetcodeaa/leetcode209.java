package leetcode;

public class leetcode209 {
    public static void main(String[] args) {
        int[] nums = new int[]{2,3,1,2,4,3};
        System.out.println(minSubArrayLen(7, nums));
    }

    public static int minSubArrayLen(int s, int[] nums) {
        if (nums.length == 0){
            return 0;
        }
        int min = nums.length + 1;
        int l=0;
        int h=0;
        int sum = nums[0];
        while (h < nums.length){
            if (sum >= s){
                min = Math.min(min, h-l+1);
                sum -= nums[l++];
            } else {
                if (h==nums.length-1){
                    break;
                }
                sum += nums[++h];
            }
        }
        return min == nums.length + 1? 0:min;
    }
}
