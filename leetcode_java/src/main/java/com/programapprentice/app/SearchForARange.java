package com.programapprentice.app;

/**
 * @author rjiang
 * @date 10/21/14
 */

/**
 * Given a sorted array of integers, find the starting and ending position of a given target value.
 *
 * Your algorithm's runtime complexity must be in the order of O(log n).
 *
 * If the target is not found in the array, return [-1, -1].
 *
 * For example,
 * Given [5, 7, 7, 8, 8, 10] and target value 8,
 * return [3, 4].
 * */
public class SearchForARange {
    public int[] searchRange(int[] A, int target) {
        int[] result = new int[2];
        result[0] = -1;
        result[1] = -1;
        if(A == null || A.length == 0) {
            return result;
        }

        int high = A.length - 1;
        int low = 0;
        int mid = 0;
        boolean found = false;
        while(low <= high) {
            mid = (low + high) / 2;
            if(A[mid] == target) {
                found = true;
                break;
            } else if (A[mid] > target) {
                high = mid - 1;
            } else if (A[mid] < target) {
                low = mid + 1;
            }
        }
        if(found) {
            low = mid;
            while(low >= 0) {
                if(A[low] != target) {
                    break;
                } else {
                    result[0] = low;
                }
                low --;
            }

            high = mid;
            while(high < A.length) {
                if(A[high] != target) {
                    break;
                } else {
                    result[1] = high;
                }
                high ++;
            }
        }

        return result;
    }
}
