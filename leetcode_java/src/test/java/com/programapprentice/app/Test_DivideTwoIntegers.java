package com.programapprentice.app;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author rjiang
 * @date 9/11/14
 */
public class Test_DivideTwoIntegers {
    DivideTwoIntegers obj = new DivideTwoIntegers();
    @Test
    public void test1() {
        int dividend = 2;
        int divisor = 1;
        int expected = 2;
        int actual = obj.divide(dividend, divisor);
        assertEquals(expected, actual);
    }

    @Test
    public void test2() {
        int dividend = 5;
        int divisor = 2;
        int expected = 2;
        int actual = obj.divide(dividend, divisor);
        assertEquals(expected, actual);
    }

    @Test
    public void test3() {
        int dividend = 2147483647;
        int divisor = 1;
        int expected = 2147483647;
        int actual = obj.divide(dividend, divisor);
        assertEquals(expected, actual);
    }

    @Test
    public void test4() {
        int dividend = 2147483647;
        int divisor = 2;
        int expected = 1073741823;
        int actual = obj.divide(dividend, divisor);
        assertEquals(expected, actual);
    }

    @Test
    public void test5() {
        int dividend = 2147483647;
        int divisor = 3;
        int expected = 715827882;
        int actual = obj.divide(dividend, divisor);
        assertEquals(expected, actual);
    }

    @Test
    public void test6() {
        int dividend = 1100540749;
        int divisor = -1090366779;
        int expected = -1;
        int actual = obj.divide(dividend, divisor);
        assertEquals(expected, actual);
    }
}
