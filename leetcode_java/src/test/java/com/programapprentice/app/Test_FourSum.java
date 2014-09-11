package com.programapprentice.app;

import org.junit.Test;

import java.util.List;

/**
 * @author rjiang
 * @date 9/11/14
 */
public class Test_FourSum {
    FourSum obj = new FourSum();
    @Test
    public void test1() {
        int[] input = {1, 0, -1, 0, -2, 2};
        int target = 0;
        List<List<Integer>> output = obj.fourSum(input, target);
        printOutput(output);
    }


    public void printOutput(List<List<Integer>> output) {
        for(List<Integer> item : output) {
            for(Integer data : item) {
                System.out.print(data + "\t");
            }
            System.out.println("");
        }
    }
}
