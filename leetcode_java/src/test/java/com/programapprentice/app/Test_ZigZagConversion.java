package com.programapprentice.app;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: ruijiang
 * Date: 9/11/14
 * Time: 5:51 PM
 */
public class Test_ZigZagConversion {
    ZigZagConversion obj = new ZigZagConversion();
    @Test
    public void test1() {
        String input = "PAYPALISHIRING";
        int nRows = 3;
        String expected = "PAHNAPLSIIGYIR";
        String actual = obj.convert(input, nRows);
        System.out.println(actual);
        assertEquals(expected, actual);
    }

    @Test
    public void test2() {
        String input = "ABC";
        int nRows = 2;
        String expected = "ACB";
        String actual = obj.convert(input, nRows);
        assertEquals(expected, actual);
    }

    @Test
    public void test3() {
        String input = "0123456789";
        int nRows = 4;
        String expected = "0615724839";
        String actual = obj.convert(input, nRows);
        assertEquals(expected, actual);
    }

    @Test
    public void test4() {
        String input = "ABCD";
        int nRows = 2;
        String expected = "ACBD";
        String actual = obj.convert(input, nRows);
        assertEquals(expected, actual);
    }

    @Test
    public void test5() {
        String input = "AGMBFHLNCEIKDJ";
        int nRows = 2;
        String expected = "AMFLCIDGBHNEKJ";
        String actual = obj.convert(input, nRows);
        assertEquals(expected, actual);
    }

    @Test
    public void test6() {
        String input = "0123456789";
        int nRows = 2;
        String expected = "0246813579";
        String actual = obj.convert(input, nRows);
        assertEquals(expected, actual);
    }
}
