package com.programapprentice.app;

import org.junit.Test;

import java.util.List;

/**
 * @author rjiang
 * @date 10/2/14
 */
public class Test_CombinationSumII {
    CombinationSumII obj = new CombinationSumII();

    @Test
    public void test1() {
        int[] num = {10,1,2,7,6,1,5};
        int target = 8;
        List<List<Integer>> output = obj.combinationSum2(num, target);
        printOutput(output);
    }

    private void printOutput(List<List<Integer>> output) {
        System.out.println("output is:");
        for(List<Integer> list : output) {
            for(Integer i : list) {
                System.out.print(i + "    ");
            }
            System.out.println();
        }
    }
}
