package com.programapprentice.app;

/**
 * Created with IntelliJ IDEA.
 * User: ruijiang
 * Date: 10/25/14
 * Time: 6:49 PM
 */
public class UniqueBinarySearchTrees {
    public int numTrees(int n) {
        if(0 == n || 1 == n) {
            return 1;
        }
        if(2 == n) {
            return 2;
        }
        int[] result = new int[n+1];
        result[0] = 1;
        result[1] = 1;
        result[2] = 2;
        for(int i = 3; i <= n; i++) {
            for(int j = 0; j < i; j++) {
                result[i] += result[j] * result[i - j - 1];
            }
        }
        return result[n];
    }
}
