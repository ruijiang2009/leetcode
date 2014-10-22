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
    // this one is working, but not efficiency enough
    public int[] searchRangeOld(int[] A, int target) {
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

    // refer http://www.lifeincode.net/programming/leetcode-search-for-a-range-java/
    public int[] searchRange(int[] A, int target) {
        int[] result = {-1, -1};
        if(A == null || A.length == 0) {
            return result;
        }
        int low = 0;
        int high = A.length - 1;

        while(low < high) {
            int mid = (low + high) / 2;
            if(A[mid] < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        int start;
        if(A[low] != target) {
            return result;
        } else {
            start = low;
        }

        low = 0;
        high = A.length - 1;
        while(low < high) {
            int mid = (low + high) / 2;
            if(A[mid] < target+1) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        int end = A[low] == target ? low : low - 1;
        result[0] = start;
        result[1] = end;
        return result;
    }

    public int[] searchRangeSolution(int[] A, int target) {
        int[] ret = {-1, -1};
        int start = 0;
        int end = A.length - 1;
        while (start < end) {
            int mid = (start + end) / 2;
            if (A[mid] < target)
                start = mid + 1;
            else
                end = mid;
        }
        int low;
        if (A[start] != target)
            return ret;
        else
            low = start;
        start = 0;
        end = A.length - 1;
        while (start < end) {
            int mid = (start + end) / 2;
            if (A[mid] < target + 1)
                start = mid + 1;
            else
                end = mid;
        }
        int high = A[start] == target ? start : start - 1;
        ret[0] = low;
        ret[1] = high;
        return ret;
    }
}
