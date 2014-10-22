package com.programapprentice.app;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * @author rjiang
 * @date 10/21/14
 */
public class Test_SearchForARange {
    SearchForARange obj = new SearchForARange();

    @Test
    public void test1() {
        int[] input = {5, 7, 7, 8, 8, 10};
        int[] expected = {3, 4};
        int[] actual = obj.searchRange(input, 8);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void test2() {
        int[] input = {5, 7, 7, 8, 8, 10};
        int[] expected = {1, 2};
        int[] actual = obj.searchRange(input, 7);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void test3() {
        int[] input = {2 ,2};
        int[] expected = {-1, -1};
        int[] actual = obj.searchRange(input, 3);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void test4() {
        int[] input = {1};
        int[] expected = {0, 0};
        int[] actual = obj.searchRange(input, 1);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void test5() {
        int[] input = {2 ,2};
        int[] expected = {0, 1};
        int[] actual = obj.searchRange(input, 2);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void test5Solution() {
        int[] input = {2 ,2};
        int[] expected = {0, 1};
        int[] actual = obj.searchRangeSolution(input, 2);
        assertArrayEquals(expected, actual);
    }
}
