package com.programapprentice.app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * User: ruijiang
 * Date: 1/9/15
 * Time: 11:05 AM
 */
public class SubsetsII {
    public List<List<Integer>> subsetsWithDup(int[] num) {
        List<List<Integer>> output = new ArrayList<List<Integer>>();
        if(num == null || num.length == 0) {
            return output;
        }
        int n = num.length;
        Arrays.sort(num);
        int preSize[] = new int[n];

        List<Integer> list = new ArrayList<Integer>();
        output.add(list);
        list = new ArrayList<Integer>();
        list.add(num[0]);
        output.add(list);
        preSize[0] = 1;
        int pre = num[0];
        int cur = 0;
        int outputSize = 0;
        for(int i = 1; i < n; i++) {
            cur = num[i];
            if(cur == pre) {
                preSize[i] = preSize[i-1];
            } else {
                preSize[i] = output.size();
            }
            outputSize = output.size();
            for(int j = outputSize - preSize[i]; j < outputSize; j++) {
                list = new ArrayList<Integer>(output.get(j));
                list.add(num[i]);
                output.add(list);
            }
            pre = cur;
        }

        return output;
    }
}
