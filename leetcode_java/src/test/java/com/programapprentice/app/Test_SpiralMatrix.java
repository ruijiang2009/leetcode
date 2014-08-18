package com.programapprentice.app;

import org.junit.Test;

import java.util.List;

/**
 * @author rjiang
 * @date 8/15/14
 */
public class Test_SpiralMatrix {
    SpiralMatrix obj = new SpiralMatrix();

    public void print(List<Integer> list) {
        for(Integer i : list) {
            System.out.print(i + ",");
        }
        System.out.println("");
    }
    @Test
    public void test1() {
        int[][] input = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        List<Integer> output = obj.spiralOrder(input);
        print(output);
    }

    @Test
    public void test2() {
        int[][] input = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14,15}, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}};
        List<Integer> output = obj.spiralOrder(input);
        print(output);
    }


    @Test
    public void test3() {
        int[][] input = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14,15}};
        List<Integer> output = obj.spiralOrder(input);
        print(output);
    }

    @Test
    public void test4() {
        int[][] input = {{1}};
        List<Integer> output = obj.spiralOrder(input);
        print(output);
    }
}
