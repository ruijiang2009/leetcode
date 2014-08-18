package com.programapprentice.app;

import org.junit.Test;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

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

    @Test
    public void test5() {
        int[][] input = {{1, 2}};
        List<Integer> output = obj.spiralOrder(input);
        print(output);
    }

    @Test
    public void test6() {
        int[][] input = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        List<Integer> output = obj.spiralOrder(input);
        print(output);
    }

    @Test
    public void test7() {
        int[][] input = {};
        List<Integer> output = obj.spiralOrder(input);
        print(output);
    }

    @Test
    public void test8() {
        int[][] input = {{}};
        List<Integer> output = obj.spiralOrder(input);
        print(output);
    }

    @Test
    public void test10() {
        int[][] input = {{1, 11}, {2, 12}, {3, 13}, {4, 14}, {5, 15}, {6, 16}, {7, 17}, {8, 18}, {9, 19}, {10, 20}};
        List<Integer> output = obj.spiralOrder(input);
        print(output);
        List<Integer> expected = new ArrayList<Integer>();
        expected.add(1);
        expected.add(11);
        expected.add(12);
        expected.add(13);
        expected.add(14);
        expected.add(15);
        expected.add(16);
        expected.add(17);
        expected.add(18);
        expected.add(19);
        expected.add(20);
        expected.add(10);
        expected.add(9);
        expected.add(8);
        expected.add(7);
        expected.add(6);
        expected.add(5);
        expected.add(4);
        expected.add(3);
        expected.add(2);
        assertEquals(expected, output);

    }
}
