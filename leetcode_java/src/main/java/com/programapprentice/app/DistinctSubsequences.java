package com.programapprentice.app;

/**
 * @author rjiang
 * @date 8/14/14
 */

import java.util.Stack;

/**
 * A subsequence of a string is a new string which is formed from the original
 * string by deleting some (can be none) of the characters without disturbing
 * the relative positions of the remaining characters. (ie, "ACE" is a subsequence
 * of "ABCDE" while "AEC" is not).
 *
 * Here is an example:
 * S = "rabbbit", T = "rabbit"

 * Return 3.
 * */

public class DistinctSubsequences {
    public int numDistinctTooSlow(String S, String T) {
        if(S == null || S.length() < T.length()) {
            return 0;
        }
        int i = 0;
        int sum = 0;

        for(i = 0; i < S.length(); i++) {
            if(S.charAt(i) == T.charAt(0)) {
                if(T.length() == 1) {
                    sum += 1;
                } else {
                    sum += numDistinctTooSlow(S.substring(i + 1), T.substring(1));
                }
            }
        }
        return sum;
    }

    // DP
    public int numDistinct(String S, String T) {
        if(S == null || S.length() < T.length()) {
            return 0;
        }
        int n = S.length();
        int m = T.length();
        int[][] nums = new int[n][m];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(j > i) {
                    break;
                }
                if(S.charAt(i) == T.charAt(j)) {
                    if(i == 0) {
                        if(j == 0) {
                            nums[i][j] = 1;
                        }
                    } else {
                        if(j == 0) {
                            nums[i][j] = nums[i - 1][j] + 1;
                        } else {
                            if (nums[i - 1][j - 1] == 0) {
                                nums[i][j] = 0;
                            } else {
                                nums[i][j] = nums[i - 1][j] + nums[i - 1][j - 1];
                            }
                        }
                    }
                } else {
                    if(i == 0) {
                        nums[i][j] = 0;
                    } else {
                        if(j == 0) {
                            nums[i][j] = nums[i-1][j];
                        } else {
                            nums[i][j] = nums[i-1][j];
                        }
                    }
                }
            }
        }
        return nums[n-1][m-1];
    }
}
