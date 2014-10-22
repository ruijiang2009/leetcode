package com.programapprentice.app;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;

/**
 * @author rjiang
 * @date 10/20/14
 */

/**
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.
 *
 * For example,
 * [1,1,2] have the following unique permutations:
 * [1,1,2], [1,2,1], and [2,1,1].
 * */


// refered http://www.programcreek.com/2013/02/leetcode-permutations-java/
// for  a new way to generate permutations
public class PermutationsII {

    public List<List<Integer>> permuteUnique(int[] num) {
        if(null == num || 0 == num.length) {
            return new ArrayList<List<Integer>>();
        }
        if(1 == num.length) {
            List<List<Integer>> output = new ArrayList<List<Integer>>();
            List<Integer> item = new ArrayList<Integer>();
            item.add(num[0]);
            output.add(item);
            return output;
        }
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        permute(num, 0, result);
        return result;
    }

    public void permute(int[] num, int start, List<List<Integer>> result) {
        if(start >= num.length) {
            List<Integer> item = convertArrayToList(num);
            result.add(item);
        }
        HashSet<Integer> hashSet= new HashSet<Integer>();
        for (int j = start; j <= num.length - 1; j++) {
            if(num[start] == num[j] && j != start) {
                continue;
            }
            if(hashSet.contains(num[j])) {
                continue;
            } else {
                hashSet.add(num[j]);
            }
            swap(num, start, j);
            permute(num, start + 1, result);
            swap(num, start, j);
        }
    }

    private List<Integer> convertArrayToList(int[] num) {
        List<Integer> item = new ArrayList<Integer>();
        for (int h = 0; h < num.length; h++) {
            item.add(num[h]);
        }
        return item;
    }

    private void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
