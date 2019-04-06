package search;

public class getUpMid {
    public static void main(String[] arg) {
        int[] arr1 = new int[]{3, 4};
        int[] arr2 = new int[]{5, 6};
        System.out.print(getUpMidValue(arr1, arr2));
    }


    public static int getUpMidValue (int[] arr1, int[] arr2) {
        int left1 = 0;
        int right1 = arr1.length - 1;
        int left2 = left1;
        int right2 = right1;
        int mid1, mid2;
        while (left1 < right1) {
            mid1 = (left1 + right1) / 2;
            mid2 = (left2 + right2) / 2;
            int offset = (right1 - left1 + 1) & 1 ^ 1;
            if (arr1[mid1] == arr2[mid2]) {
                return arr1[mid1];
            } else if (arr1[mid1] > arr2[mid2]) {
                right1 = mid1;
                left2 = mid2 + offset;
            } else {
                right2 = mid2;
                left1 = mid1 + offset;
            }
        }
        return Math.min(arr1[left1], arr2[left2]);
    }
}
