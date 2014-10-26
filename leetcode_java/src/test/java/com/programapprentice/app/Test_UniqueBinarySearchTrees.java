package com.programapprentice.app;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: ruijiang
 * Date: 10/25/14
 * Time: 7:35 PM
 */
public class Test_UniqueBinarySearchTrees {
    UniqueBinarySearchTrees obj = new UniqueBinarySearchTrees();

    @Test
    public void test1() {
        int input = 3;
        int expected = 5;
        int actual = obj.numTrees(input);
        assertEquals(expected, actual);
    }

    @Test
    public void test2() {
        int input = 4;
        int expected = 14;
        int actual = obj.numTrees(input);
        assertEquals(expected, actual);
    }

}
