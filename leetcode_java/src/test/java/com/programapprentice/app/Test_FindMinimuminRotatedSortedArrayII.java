package com.programapprentice.app;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * User: ruijiang
 * Date: 11/2/14
 * Time: 12:14 AM
 */
public class Test_FindMinimuminRotatedSortedArrayII {
    FindMinimuminRotatedSortedArrayII obj = new FindMinimuminRotatedSortedArrayII();

    @Test
    public void test1() {
        int[] input = {4, 5, 6, 7, 0, 1, 2};
        int expected = 0;
        int actual = obj.findMin(input);
        assertEquals(expected, actual);
    }

    @Test
    public void test2() {
        int[] input = {4, 5, 6, 7, 0, 0, 1, 1, 2};
        int expected = 0;
        int actual = obj.findMin(input);
        assertEquals(expected, actual);
    }

    @Test
    public void test3() {
        int[] input = {1, 1};
        int expected = 1;
        int actual = obj.findMin(input);
        assertEquals(expected, actual);
    }

    @Test
    public void test4() {
        int[] input = {3, 3, 1, 3};
        int expected = 1;
        int actual = obj.findMin(input);
        assertEquals(expected, actual);
    }

    @Test
    public void test5() {
        int[] input = {10,1,10,10,10};
        int expected = 1;
        int actual = obj.findMin(input);
        assertEquals(expected, actual);
    }

    @Test
    public void test6() {
        int[] input = {2,0,1,1,1};
        int expected = 0;
        int actual = obj.findMin(input);
        assertEquals(expected, actual);
    }

    @Test
    public void test7() {
        int[] input = {1,1,2,0,0,1};
        int expected = 0;
        int actual = obj.findMin(input);
        assertEquals(expected, actual);
    }
}