package com.programapprentice.app;

/**
 * @author rjiang
 * @date 10/2/14
 */

import java.util.*;

/**
 * Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
 *
 * Each number in C may only be used once in the combination.
 *
 * Note:
 * All numbers (including target) will be positive integers.
 * Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
 * The solution set must not contain duplicate combinations.
 * For example, given candidate set 10,1,2,7,6,1,5 and target 8,
 * A solution set is:
 * [1, 7]
 * [1, 2, 5]
 * [2, 6]
 * [1, 1, 6]
 * */

public class CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] num, int target) {
        if (num == null || num.length == 0) {
            return new ArrayList<List<Integer>>();
        }
        Arrays.sort(num);
        if (num[0] > target) {
            return new ArrayList<List<Integer>>();
        }
        boolean[] visited = new boolean[num.length];
        Set<List<Integer>> s = combination(num, target, visited, 0);
        return new ArrayList<List<Integer>>(s);
    }


    public Set<List<Integer>> combination(int[] candidates, int target, boolean[] visited, int startIndex) {
        if (candidates[0] > target) {
            return new HashSet<List<Integer>>();
        }
        Set<List<Integer>> output = new HashSet<List<Integer>>();

        List<Integer> list = null;
        for (int i = startIndex; i < candidates.length; i++) {
            if (candidates[i] == target && !visited[i]) {
                list = new ArrayList<Integer>();
                list.add(candidates[i]);
                output.add(list);
            } else if (candidates[i] < target && !visited[i]) {
                visited[i] = true;
                Set<List<Integer>> tmpOutput = combination(candidates, target - candidates[i], visited, i+1);
                for (List<Integer> tmp : tmpOutput) {
                    tmp.add(candidates[i]);
                    Collections.sort(tmp);
                    output.add(tmp);
                }
                visited[i] = false;
            } else {
                continue;
            }
        }
        return output;
    }
}