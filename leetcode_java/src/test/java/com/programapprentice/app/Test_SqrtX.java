package com.programapprentice.app;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * User: ruijiang
 * Date: 11/1/14
 * Time: 11:23 PM
 */
public class Test_SqrtX {
    SqrtX obj = new SqrtX();

    @Test
    public void test1() {
        int input = 4;
        int expected = 2;
        int actual = obj.sqrt(input);
        assertEquals(expected, actual);
    }

    @Test
    public void test2() {
        int input = 8;
        int expected = 2;
        int actual = obj.sqrt(input);
        assertEquals(expected, actual);
    }
}
