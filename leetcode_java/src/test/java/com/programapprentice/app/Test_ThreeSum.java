package com.programapprentice.app;

import org.junit.Test;

import java.util.List;

/**
 * @author rjiang
 * @date 9/9/14
 */
public class Test_ThreeSum {
    ThreeSum obj = new ThreeSum();
    @Test
    public void test1() {
        int[] input = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> output = obj.threeSum(input);
        printOutput(output);
    }

    @Test
    public void test2() {
        int[] input = {0, 0, 0, 0};
        List<List<Integer>> output = obj.threeSum(input);
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
