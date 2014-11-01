package com.programapprentice.app;

/**
 * Created with IntelliJ IDEA.
 * User: ruijiang
 * Date: 10/26/14
 * Time: 10:20 PM
 */

/**
 * Find the contiguous subarray within an array (containing at least one number) which has the largest product.
 * For example, given the array [2,3,-2,4],
 * the contiguous subarray [2,3] has the largest product = 6.
 * */
public class MaximumProductSubarray {

    // brute force method O(n^2)
    public int maxProductV1(int[] A) {
        if(A == null || A.length == 0) {
            return 0;
        }
        int n = A.length;
        int[][] scan = new int[n][n];
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++) {
            scan[i][i] = A[i];
            max = max > scan[i][i] ? max : scan[i][i];
            for(int j = i+1; j < n; j++) {
                scan[i][j] = scan[i][j-1] * A[j];
                max = max > scan[i][j] ? max : scan[i][j];
            }
        }

        return max;
    }

    public int maxProduct(int[] A) {
        if(A == null || A.length == 0) {
            return 0;
        }
        int max = A[0];
        int min = A[0];
        int globalMax = A[0];
        int tmpMax = max;
        int tmpMin = min;
        for(int i = 1; i < A.length; i++) {
            tmpMax = max;
            tmpMin = min;
            max = max3(tmpMax * A[i], tmpMin*A[i], A[i]);
            min = min3(tmpMax * A[i], tmpMin*A[i], A[i]);
            globalMax = Math.max(globalMax, max);
        }
        return globalMax;
    }

    public int max3(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }

    public int min3(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }

    // http://blog.csdn.net/worldwindjp/article/details/39826823
    public int maxProductSolution(int[] A) {
        if(A == null || A.length == 0) {
            return 0;
        }
        int max_local = A[0];
        int min_local = A[0];
        int global = A[0];

        for(int i=1;i<A.length;i++)
        {
            int max_copy = max_local;
            max_local = Math.max(Math.max(A[i]*max_local, A[i]), A[i]*min_local);
            min_local = Math.min(Math.min(A[i]*max_copy, A[i]), A[i]*min_local);
            global = Math.max(global, max_local);
        }
        return global;
    }
}
