package com.programapprentice.app;

import java.util.*;

/**
 * @author rjiang
 * @date 9/11/14
 */

/**
 * Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.
 *
 * Note:
 * Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d)
 * The solution set must not contain duplicate quadruplets.
 * For example, given array S = {1 0 -1 0 -2 2}, and target = 0.
 *
 * A solution set is:
 * (-1,  0, 0, 1)
 * (-2, -1, 1, 2)
 * (-2,  0, 0, 2)*/
public class FourSum {
    public List<List<Integer>> fourSum(int[] num, int target) {
        Arrays.sort(num);
        Set<List<Integer>> output = new HashSet<List<Integer>>();
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(num == null || num.length < 4) {
            return result;
        }
        int goal = 0;
        int high = 0;
        int low = 0;
        int tmp = 0;
        List<Integer> item = null;
        for(int i = 0; i < num.length; i++) {
            for(int j = i + 1; j < num.length; j++) {
                goal = target - num[i] - num[j];
                low = j + 1;
                high = num.length - 1;
                while(low < high) {
                    if(low == i) {
                        low ++;
                        continue;
                    } else if(high == i) {
                        high --;
                        continue;
                    }
                    tmp = num[low] + num[high];
                    if(tmp == goal) {
                        item = new ArrayList<Integer>();
                        item.add(num[i]);
                        item.add(num[j]);
                        item.add(num[low]);
                        item.add(num[high]);
                        output.add(item);
                        low ++;
                        high --;
                    } else if (tmp < goal) {
                        low ++;
                    } else if (tmp > goal) {
                        high --;
                    }
                }
            }
        }
        result.addAll(output);
        return result;
    }
}
