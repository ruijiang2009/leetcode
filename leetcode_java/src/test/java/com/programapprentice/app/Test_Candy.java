package com.programapprentice.app;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: ruijiang
 * Date: 8/2/14
 * Time: 11:35 AM
 */
public class Test_Candy {
    Candy obj = new Candy();

    @Test
    public void test1() {
        int[] ratings = {6, 4, 3, 2, 1};
        int expected = 15;
        int output = obj.candy(ratings);
        assertEquals(expected, output);
    }

    @Test
    public void test2() {
        int[] ratings = {1, 6, 4, 3, 2, 1};
        int expected = 16;
        int output = obj.candy(ratings);
        assertEquals(expected, output);
    }

    @Test
    public void test3() {
        int[] ratings = {1, 22, 24, 23, 22, 21, 1};
        int expected = 18;
        int output = obj.candy(ratings);
        assertEquals(expected, output);
    }

    @Test
    public void test4() {
        int[] ratings = {1, 2, 2};
        int expected = 4;
        int output = obj.candy(ratings);
        assertEquals(expected, output);
    }

    @Test
    public void test5() {
        int[] ratings = {2, 2, 1};
        int expected = 4;
        int output = obj.candy(ratings);
        assertEquals(expected, output);
    }
}
