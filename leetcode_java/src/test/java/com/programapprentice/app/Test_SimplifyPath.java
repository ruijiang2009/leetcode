package com.programapprentice.app;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author rjiang
 * @date 8/18/14
 */
public class Test_SimplifyPath {
    SimplifyPath obj = new SimplifyPath();

    @Test
    public void test1() {
        String input = "/home/";
        String output = obj.simplifyPath(input);
        String expected = "/home";
        assertEquals(expected, output);
    }

    @Test
    public void test2() {
        String input = "/a/./b/../../c/";
        String output = obj.simplifyPath(input);
        String expected = "/c";
        assertEquals(expected, output);
    }

    @Test
    public void test3() {
        String input = "/";
        String output = obj.simplifyPath(input);
        String expected = "/";
        assertEquals(expected, output);
    }
}


