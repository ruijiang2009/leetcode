package com.programapprentice.app;

import java.util.*;

/**
 * @author rjiang
 * @date 10/1/14
 */

/**
 * * Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
 *
 * The same repeated number may be chosen from C unlimited number of times.
 *
 * Note:
 * All numbers (including target) will be positive integers.
 * Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
 * The solution set must not contain duplicate combinations.
 * For example, given candidate set 2,3,6,7 and target 7,
 * A solution set is:
 * [7]
 * [2, 2, 3]
 */

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if(candidates == null || candidates.length == 0) {
            return new ArrayList<List<Integer>>();
        }
        Arrays.sort(candidates);
        if(candidates[0] > target) {
            return new ArrayList<List<Integer>>();
        }
        Set<List<Integer>> s = combination2(candidates, target);
        return new ArrayList<List<Integer>>(s);
    }


    public Set<List<Integer>> combination2(int[] candidates, int target) {
        if(candidates[0] > target) {
            return new HashSet<List<Integer>>();
        }
        Set<List<Integer>> output = new HashSet<List<Integer>>();

        List<Integer> list = null;
        for(int i = 0; i < candidates.length; i++) {
            if(i > 0 && candidates[i] == candidates[i-1]) {
                // this is to check duplicates
                continue;
            }
            if(candidates[i] == target) {
                list = new ArrayList<Integer>();
                list.add(candidates[i]);
                output.add(list);
            } else if (candidates[i] < target) {
                Set<List<Integer>> tmpOutput = combination2(candidates, target - candidates[i]);
                for(List<Integer> tmp : tmpOutput) {
                    tmp.add(candidates[i]);
                    Collections.sort(tmp);
                    output.add(tmp);
                }
            } else {
                continue;
            }
        }
        return output;
    }

    public List<List<Integer>> combination(int[] candidates, int target) {
        if(candidates[0] > target) {
            return new ArrayList<List<Integer>>();
        }
        List<List<Integer>> output = new ArrayList<List<Integer>>();

        List<Integer> list = null;
        for(int i = 0; i < candidates.length; i++) {
            if(i > 0 && candidates[i] == candidates[i-1]) {
                // this is to check duplicates
                continue;
            }
            if(candidates[i] == target) {
                list = new ArrayList<Integer>();
                list.add(candidates[i]);
                output.add(list);
            } else if (candidates[i] < target) {
                List<List<Integer>> tmpOutput = combination(candidates, target - candidates[i]);
                for(List<Integer> tmp : tmpOutput) {
                    tmp.add(candidates[i]);
                    Collections.sort(tmp);
                    output.add(tmp);
                }
            } else {
                continue;
            }
        }
        return output;
    }
}
