package swordoffer.knowledge.migrate;

public class GetNumberOfK {
    /**
     * 统计一个数字在排序数组中出现的次数。
     */
    public static void main(String[] args) {
        int[] test0 = new int[]{1,2,3,3,3,3,3,3,6,7};
        System.out.println(GetNumberOfK(test0,3));
    }

    public static int GetNumberOfK(int [] array , int k) {
        int firstK = GetFirstK(array, k, 0, array.length);
        int lastK = GetLastK(array, k, 0, array.length);
        if (firstK != -1 && lastK!= -1) {
            return lastK - firstK + 1;
        }
        return -1;
    }

    public static int GetFirstK(int[] array, int k, int start, int end) {
        if (start > end)
            return -1;
        int mid = (start + end) >> 1;
        if (array[mid] == k) {
            if (mid == 0 || array[mid-1] !=k)
                return mid;
            else {
                return GetFirstK(array, k, start, mid);
            }
        } else if (array[mid] < k){
            return GetFirstK(array, k, mid, end);
        } else {
            return GetFirstK(array, k, start, mid);
        }
    }

    public static int GetLastK(int[] array, int k, int start, int end) {
        if (start > end)
            return -1;
        int mid = (start + end) >> 1;
        if (array[mid] == k) {
            if ((mid < array.length-1 && array[mid+1] !=k) || mid == array.length-1)
                return mid;
            else {
                return GetLastK(array, k, mid+1, end);
            }
        } else if (array[mid] < k){
            return GetLastK(array, k, mid + 1, end);
        } else {
            return GetLastK(array, k, start, mid - 1);
        }
    }
}
