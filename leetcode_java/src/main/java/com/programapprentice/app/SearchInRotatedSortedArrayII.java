package com.programapprentice.app;

/**
 * Created with IntelliJ IDEA.
 * User: ruijiang
 * Date: 1/11/15
 * Time: 3:28 PM
 */
public class SearchInRotatedSortedArrayII {
    public boolean search(int[] A, int target) {
        if(A == null || A.length == 0) {
            return false;
        }
        if(1 == A.length) {
            return A[0] == target;
        }
        int low = 0;
        int high = A.length - 1;
        int mid;
        while(low <= high) {
            mid = (low + high) / 2;
            if(A[mid] == target) {
                return true;
            }
            if(A[mid] < A[high]) {
                // mid to high no rotation
                if(A[mid] < target && target <= A[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            } else if(A[mid] > A[high]) {
                // low to mid no rotation
                if(A[mid] > target && target >= A[low]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                high--;
            }
        }
        return false;
    }
}
