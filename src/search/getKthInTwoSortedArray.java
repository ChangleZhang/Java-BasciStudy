package search;

import java.util.Arrays;

public class getKthInTwoSortedArray {
    public static void main(String[] args) {
        int[] arr1 = new int[]{3, 4};
        int[] arr2 = new int[]{5, 6};
        System.out.println(getKth(arr1, arr2,2));
        System.out.println(getKth(arr1, arr2,3));
        int[] arr3 = new int[]{1, 2, 3, 4, 5};
        int[] arr4 = new int[]{4, 8};
        System.out.println(getKth(arr3, arr4,2));
        System.out.println(getKth(arr3, arr4,3));
        System.out.println(getKth(arr3, arr4,6));
    }


    private static int getKth(int[] arr1, int[] arr2, int k) {
        if (null == arr1 || arr1.length == 0) {
            return arr2[k];
        }
        if (null == arr2 || arr2.length == 0) {
            return arr1[k];
        }
        // init
        int[] shortArr;
        int[] longArr;
        if (arr1.length < arr2.length) {
            shortArr = arr1;
            longArr = arr2;
        } else {
            shortArr = arr2;
            longArr = arr1;
        }
        int lenS = shortArr.length;
        int lenL = longArr.length;
        // calc
        if (k <= lenS) {
            return getUpMid.getUpMidValue(Arrays.copyOfRange(shortArr, 0, k), Arrays.copyOfRange(longArr, 0 , k));
        } else if (k > lenL) {
            if (longArr[k - lenS - 1] > shortArr[lenS-1]) {
                return longArr[k - lenS - 1];
            } else if (shortArr[k - lenL - 1] > longArr[lenL-1]) {
                return shortArr[k - lenL - 1];
            } else {
                return getUpMid.getUpMidValue(Arrays.copyOfRange(shortArr, k-lenL, lenS), Arrays.copyOfRange(longArr, k-lenS , lenL));
            }
        } else {
            if (longArr[k - lenS - 1] > shortArr[lenS-1]) {
                return longArr[k - lenS - 1];
            } else {
                return getUpMid.getUpMidValue(Arrays.copyOfRange(shortArr, 0, lenS), Arrays.copyOfRange(longArr, k-lenS , k));
            }
        }
    }
}
