package com.programapprentice.app;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * @author rjiang
 * @date 10/17/14
 */
public class Test_RegularExpressionMatching {
    RegularExpressionMatching obj = new RegularExpressionMatching();

    @Test
    public void test1() {
        String s = "aa";
        String p = "a";
        boolean expected = false;
        boolean actual = obj.isMatch(s, p);
        assertEquals(expected, actual);
    }

    @Test
    public void test2() {
        String s = "aa";
        String p = "aa";
        boolean expected = true;
        boolean actual = obj.isMatch(s, p);
        assertEquals(expected, actual);
    }

    @Test
    public void test3() {
        String s = "aaa";
        String p = "aa";
        boolean expected = false;
        boolean actual = obj.isMatch(s, p);
        assertEquals(expected, actual);
    }

    @Test
    public void test4() {
        String s = "aa";
        String p = "a*";
        boolean expected = true;
        boolean actual = obj.isMatch(s, p);
        assertEquals(expected, actual);
    }

    @Test
    public void test5() {
        String s = "aa";
        String p = ".*";
        boolean expected = true;
        boolean actual = obj.isMatch(s, p);
        assertEquals(expected, actual);
    }

    @Test
    public void test6() {
        String s = "ab";
        String p = ".*";
        boolean expected = true;
        boolean actual = obj.isMatch(s, p);
        assertEquals(expected, actual);
    }

    @Test
    public void test7() {
        String s = "aab";
        String p = "c*a*b";
        boolean expected = true;
        boolean actual = obj.isMatch(s, p);
        assertEquals(expected, actual);
    }

    @Test
    public void test8() {
        String s = "aa";
        String p = "aa";
        boolean expected = true;
        boolean actual = obj.isMatch(s, p);
        assertEquals(expected, actual);
    }

    @Test
    public void test9() {
        String s = "ab";
        String p = ".*b*";
        boolean expected = true;
        boolean actual = obj.isMatch(s, p);
        assertEquals(expected, actual);
    }

    @Test
    public void test10() {
        String s = "ab";
        String p = ".*bb*";
        boolean expected = true;
        boolean actual = obj.isMatch(s, p);
        assertEquals(expected, actual);
    }

    @Test
    public void test11() {
        String s = "abc";
        String p = ".*b*";
        boolean expected = true;
        boolean actual = obj.isMatch(s, p);
        assertEquals(expected, actual);
    }
}
