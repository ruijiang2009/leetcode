package com.programapprentice.app;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: ruijiang
 * Date: 10/2/14
 * Time: 7:14 PM
 */
public class Test_WildcardMatching {
    WildcardMatching obj = new WildcardMatching();

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
        String p = "*";
        boolean expected = true;
        boolean actual = obj.isMatch(s, p);
        assertEquals(expected, actual);
    }

    @Test
    public void test5() {
        String s = "aa";
        String p = "a*";
        boolean expected = true;
        boolean actual = obj.isMatch(s, p);
        assertEquals(expected, actual);
    }

    @Test
    public void test6() {
        String s = "ab";
        String p = "?*";
        boolean expected = true;
        boolean actual = obj.isMatch(s, p);
        assertEquals(expected, actual);
    }

    @Test
    public void test7() {
        String s = "aab";
        String p = "c*a*b";
        boolean expected = false;
        boolean actual = obj.isMatch(s, p);
        assertEquals(expected, actual);
    }

    @Test
    public void test8() {
        String s = "a";
        String p = "";
        boolean expected = false;
        boolean actual = obj.isMatch(s, p);
        assertEquals(expected, actual);
    }

    @Test
    public void test9() {
        String s = "bcd";
        String p = "??";
        boolean expected = false;
        boolean actual = obj.isMatch(s, p);
        assertEquals(expected, actual);
    }

    @Test
    public void test10() {
        String s = "aababcabc";
        String p = "a*ab*abc";
        boolean expected = true;
        boolean actual = obj.isMatch(s, p);
        assertEquals(expected, actual);
    }
}
