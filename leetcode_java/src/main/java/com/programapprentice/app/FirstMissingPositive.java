package com.programapprentice.app;

/**
 * @author rjiang
 * @date 9/25/14
 */

/**
 * Given an unsorted integer array, find the first missing positive integer.
 *
 * For example,
 * Given [1,2,0] return 3,
 * and [3,4,-1,1] return 2.
 *
 * Your algorithm should run in O(n) time and uses constant space.
 * */
public class FirstMissingPositive {
    public int firstMissingPositive(int[] A) {
        if(A == null || A.length == 0) {
            return 1;
        }
        int tmp = 0;

        int start = 0;
        while(start < A.length) {
            if(A[start] == start + 1) {
                start++;
                continue;
            } else {
                if(A[start] > 0 && A[start] <= A.length) {
                    if(A[A[start] - 1] == A[start]) {
                        start++;
                        continue;
                    }
                    tmp = A[A[start] - 1];
                    A[A[start] - 1] = A[start];
                    A[start] = tmp;
                } else {
                    start++;
                }
            }
        }

        int result = 0;
        for(int i = 0; i < A.length; i++) {
            if(A[i] != i + 1) {
                result = i + 1;
                break;
            }
        }
        if(0 == result) {
            result = A.length + 1;
        }
        return result;
    }
}
