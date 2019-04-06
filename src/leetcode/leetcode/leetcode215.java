package leetcode;

public class leetcode215 {
    public static  void main(String[] args) {
        int[] t = new int[]{2,1};
        int res = findKthLargest(t,2);
        System.out.println(res);
    }

    public static int findKthLargest(int[] nums, int k) {
        int idx = nums.length - k;
        int l = 0, h = nums.length - 1, pos = -1;
        while (pos != idx) {
            pos = partSearch(nums, l , h);
            if (pos < idx){
                l = pos + 1;
            } else {
                h = pos - 1;
            }
        }
        return nums[pos];
    }

    private static int partSearch (int[] nums, int l, int h) {
        int val = nums[h], pos = l;
        for ( int i =l; i< h; i++){
            if (nums[i] < val) {
                swap(nums, pos ++, i);
            }
        }
        swap(nums, pos, h);
        return pos;
    }

    private static void swap(int[]nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
