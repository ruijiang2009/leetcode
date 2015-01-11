package com.programapprentice.app;

/**
 * Created with IntelliJ IDEA.
 * User: ruijiang
 * Date: 1/11/15
 * Time: 3:04 PM
 */
/**
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 * You may assume no duplicate exists in the array.
 */

// reference: http://blog.csdn.net/linhuanmars/article/details/20525681
public class SearchInRoratedSortedArray {
    public int search(int[] A, int target) {
        if(A == null || A.length == 0) {
            return -1;
        }
        int low = 0;
        int high = A.length-1;
        int mid = 0;
        while(low <= high) {
            mid = (low + high) / 2;
            if(A[mid] == target) {
                return mid;
            }
            if(A[mid] < A[high]) {
                // mid to high no rotation
                if(A[mid] < target && target <= A[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            } else {
                // low to mid no rotation
                if(A[mid] > target && target >= A[low]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }
        return -1;
    }

}
