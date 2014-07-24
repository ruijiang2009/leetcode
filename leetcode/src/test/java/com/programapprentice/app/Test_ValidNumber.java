package com.programapprentice.app;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author rjiang
 * @date 7/24/14
 */
public class Test_ValidNumber {
    @Test
    public void test() {
        String input = "0";
        boolean output = ValidNumber.isNumber(input);
        boolean expected = true;
        assertEquals(expected, output);
    }

    @Test
    public void test1() {
        String input = " 0.1 ";
        boolean output = ValidNumber.isNumber(input);
        boolean expected = true;
        assertEquals(expected, output);
    }

    @Test
    public void test2() {
        String input = "abc";
        boolean output = ValidNumber.isNumber(input);
        boolean expected = false;
        assertEquals(expected, output);
    }

    @Test
    public void test3() {
        String input = "1 a";
        boolean output = ValidNumber.isNumber(input);
        boolean expected = false;
        assertEquals(expected, output);
    }

    @Test
    public void test4() {
        String input = "2e10";
        boolean output = ValidNumber.isNumber(input);
        boolean expected = true;
        assertEquals(expected, output);
    }

    @Test
    public void test5() {
        String input = "e";
        boolean output = ValidNumber.isNumber(input);
        boolean expected = false;
        assertEquals(expected, output);
    }

    @Test
    public void test6() {
        String input = "e1";
        boolean output = ValidNumber.isNumber(input);
        boolean expected = false;
        assertEquals(expected, output);
    }

    @Test
    public void test7() {
        String input = "1e.1";
        boolean output = ValidNumber.isNumber(input);
        boolean expected = false;
        assertEquals(expected, output);
    }


    @Test
    public void test8() {
        String input = "1e0.1";
        boolean output = ValidNumber.isNumber(input);
        boolean expected = true;
        assertEquals(expected, output);
    }

    @Test
    public void test9() {
        String input = ".";
        boolean output = ValidNumber.isNumber(input);
        boolean expected = false;
        assertEquals(expected, output);
    }

    @Test
    public void test10() {
        String input = "3.";
        boolean output = ValidNumber.isNumber(input);
        boolean expected = true;
        assertEquals(expected, output);
    }


    @Test
    public void test11() {
        String input = ".3";
        boolean output = ValidNumber.isNumber(input);
        boolean expected = true;
        assertEquals(expected, output);
    }

}
