package com.programapprentice.app;

import org.junit.Test;

import java.util.List;

/**
 * @author rjiang
 * @date 10/21/14
 */
public class Test_PermutationsII {
    PermutationsII obj = new PermutationsII();

    @Test
    public void test1() {
        int[] input = {1, 1, 2};
        List<List<Integer>> output = obj.permuteUnique(input);
        printOutput(output);

    }

    @Test
    public void test2() {
        int[] input = {1, 1, 2, 2};
        List<List<Integer>> output = obj.permuteUnique(input);
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
