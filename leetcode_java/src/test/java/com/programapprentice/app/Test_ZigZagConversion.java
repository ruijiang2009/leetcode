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
        String input = "Actual   :AGMBFHLNCEIKDJ\n";
        int nRows = 4;
        String expected = "ACB";
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
}
