package com.programapprentice.app;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author rjiang
 * @date 8/26/14
 */
public class Test_DecodeWays {
    DecodeWays obj = new DecodeWays();
    @Test
    public void test1() {
        String input="";
        int actual = obj.numDecodings(input);
        int expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    public void test2() {
        String input = "0";
        int actual = obj.numDecodings(input);
        int expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    public void test3() {
        String input = "00";
        int actual = obj.numDecodings(input);
        int expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    public void test4() {
        String input = "012";
        int actual = obj.numDecodings(input);
        int expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    public void test5() {
        String input = "100";
        int actual = obj.numDecodings(input);
        int expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    public void test6() {
        String input = "110";
        int actual = obj.numDecodings(input);
        int expected = 1;
        assertEquals(expected, actual);
    }

    @Test
    public void test7() {
        String input = "1120";
        int actual = obj.numDecodings(input);
        int expected = 2;
        assertEquals(expected, actual);
    }

    @Test
    public void test8() {
        String input = "1180";
        int actual = obj.numDecodings(input);
        int expected = 0;
        assertEquals(expected, actual);
    }

    /**
    1 1

    2
    1 2
    12

    3
    12 1
    1 21
    1 2 1

    4
    12 12
    12 1 2
    1 21 2
    1 2 1 2
    */
    @Test
    public void test9() {
        String input = "1212";
        int actual = obj.numDecodings(input);
        int expected = 5;
        assertEquals(expected, actual);
    }

    @Test
    public void test10() {
        String input = "121";
        int actual = obj.numDecodings(input);
        int expected = 3;
        assertEquals(expected, actual);
    }

    @Test
    public void test11() {
        String input = "230";
        int actual = obj.numDecodings2(input);
        int expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    public void test12() {
        String input = "301";
        int actual = obj.numDecodings2(input);
        int expected = 1;
        assertEquals(expected, actual);
    }

    @Test
    public void test13() {
        String input = "27";
        int actual = obj.numDecodings2(input);
        int expected = 1;
        assertEquals(expected, actual);
    }

    @Test
    public void test14() {
        String input = "101";
        int actual = obj.numDecodings2(input);
        int expected = 1;
        assertEquals(expected, actual);
    }
}



