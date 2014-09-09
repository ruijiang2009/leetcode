package com.programapprentice.app;

/**
 * @author rjiang
 * @date 9/9/14
 */

import java.util.*;

/**
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 *
 * Note:
 * Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
 * The solution set must not contain duplicate triplets.
 * For example, given array S = {-1 0 1 2 -1 -4},
 *
 * A solution set is:
 * (-1, 0, 1)
 * (-1, -1, 2)*/
public class ThreeSum {
    // version 1 has duplicates
    public List<List<Integer>> threeSumV1(int[] num) {
        Arrays.sort(num);
        List<List<Integer>> output = new ArrayList<List<Integer>>();
        if(num == null || num.length < 3) {
            return output;
        }
        int goal = 0;
        int high = 0;
        int low = 0;
        int tmp = 0;
        List<Integer> item = null;
        for(int i = 0; i < num.length; i++) {
            if(i > 1 && num[i] == num[i-1]) {
                continue;
            }
            goal = 0 - num[i];
            low = i+1;
            high = num.length-1;
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
        return output;
    }


    public List<List<Integer>> threeSum(int[] num) {
        Arrays.sort(num);
        Set<List<Integer>> output = new HashSet<List<Integer>>();
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(num == null || num.length < 3) {
            return result;
        }
        int goal = 0;
        int high = 0;
        int low = 0;
        int tmp = 0;
        List<Integer> item = null;
        for(int i = 0; i < num.length; i++) {
            if(i > 1 && num[i] == num[i-1]) {
                continue;
            }
            goal = 0 - num[i];
            low = i+1;
            high = num.length-1;
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
        result.addAll(output);
        return result;
    }
}
