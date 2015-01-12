package com.programapprentice.app;

/**
 * Created with IntelliJ IDEA.
 * User: ruijiang
 * Date: 1/11/15
 * Time: 4:47 PM
 */
/**
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * Find the minimum element.
 * The array may contain duplicates.
 */
public class FindMinimumInRotatedSortedArrayII {
    public int findMin(int[] num) {
        if(num == null || num.length == 0) {
            return 0;
        }
        if(1 == num.length) {
            return num[0];
        }
        int low = 0;
        int high = num.length - 1;
        int mid;
        int n = num.length;
        while(low <= high) {
            mid = (low + high) / 2;
            if(num[(mid - 1 + n) % n] > num[mid] && num[(mid + 1) % n] >= num[mid]) {
                return num[mid];
            }
            if(num[mid] < num[high]) {
                high = (mid - 1) % n;
            } else if (num[mid] > num[high]) {
                low = (mid + 1) % n;
            } else {
                high --;
            }
        }
        return num[low];
    }
}
