package com.programapprentice.app;

/**
 * @author rjiang
 * @date 9/10/14
 */

import java.util.Arrays;

/**
 * Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.
 *
 * For example, given array S = {-1 2 1 -4}, and target = 1.

 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).*/
public class ThreeSumClosest {
    public int threeSumClosest(int[] num, int target) {
        if(num == null || num.length < 3) {
            return 0;
        }
        Arrays.sort(num);
        int diff = Integer.MAX_VALUE;
        int goal = 0;
        int high = 0;
        int low = 0;
        int tmp = 0;
        int tmpDiff = 0;
        for(int i = 0; i < num.length; i++) {
            if(i > 1 && num[i] == num[i-1]) {
                continue;
            }
            goal = target - num[i];
            low = i + 1;
            high = num.length - 1;
            while(low < high) {
                if(high == i) {
                    high --;
                    continue;
                }
                tmp = num[low] + num[high];
                if(tmp == goal) {
                    return target;
                }
                tmpDiff = num[i] + num[low] + num[high] - target;
                diff = Math.abs(diff) > Math.abs(tmpDiff) ? tmpDiff : diff;
                if (tmp < goal) {
                    low++;
                } else if (tmp > goal) {
                    high--;
                }
            }
        }
        return target + diff;
    }
}
