package com.programapprentice.app;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * User: ruijiang
 * Date: 10/21/14
 * Time: 7:06 PM
 */
public class Test_FindMinimumInRotatedSortedArray {
    FindMinimumInRotatedSortedArray obj = new FindMinimumInRotatedSortedArray();

    @Test
    public void test1() {
        int[] num = {4, 5, 6, 7, 0, 1, 2};
        int expected = 0;
        int actual = obj.findMin(num);
        assertEquals(expected, actual);
    }

    @Test
    public void test2() {
        int[] num = {5, 6, 7, 0, 1, 2, 4};
        int expected = 0;
        int actual = obj.findMin(num);
        assertEquals(expected, actual);
    }

    @Test
    public void test3() {
        int[] num = {1, 2};
        int expected = 1;
        int actual = obj.findMin(num);
        assertEquals(expected, actual);
    }

    @Test
    public void test4() {
        int[] num = {2, 1};
        int expected = 1;
        int actual = obj.findMin(num);
        assertEquals(expected, actual);
    }

    @Test
    public void test5() {
        int[] num = {2, 3, 1};
        int expected = 1;
        int actual = obj.findMin(num);
        assertEquals(expected, actual);
    }

}
