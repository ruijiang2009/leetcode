package com.programapprentice.app;

/**
 * User: ruijiang
 * Date: 10/21/14
 * Time: 6:46 PM
 */
/**
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * Find the minimum element.
 * You may assume no duplicate exists in the array.
 * */
public class FindMinimumInRotatedSortedArray {
    public int findMin(int[] num) {
        if(num == null || num.length == 0) {
            return 0;
        }
        if(num.length == 1) {
            return num[0];
        }
        int low = 0;
        int high = num.length-1;
        int mid = 0;
        while(low <= high) {
            mid = (high + low) / 2;
            // if mid is min, return it. Otherwise it needs to move high and low
            if(num[(mid - 1 + num.length) % num.length] > num[mid] && num[(mid + 1) % num.length] > num[mid]) {
                return num[mid];
            }
            if(num[mid] > num[high]) {
                low = (mid + 1) % num.length;
            } else {
                high = (mid - 1 + num.length) % num.length;
            }
        }
        return num[low];
    }
}