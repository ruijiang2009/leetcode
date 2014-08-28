package com.programapprentice.app;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * User: ruijiang
 * Date: 8/27/14
 * Time: 7:31 PM
 */
public class Test_MaximalRectangle {
    MaximalRectangle obj = new MaximalRectangle();
    @Test
    public void test1() {
        char[][] input = {{'1'}};
        int actual = obj.maximalRectangle(input);
        int expected = 1;
        assertEquals(expected, actual);
    }

    @Test
    public void test2() {
        char[][] input = {{'0', '1'}};
        int actual = obj.maximalRectangle(input);
        int expected = 1;
        assertEquals(expected, actual);
    }
}
