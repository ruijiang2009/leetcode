package com.programapprentice.app;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author rjiang
 * @date 9/10/14
 */
public class Test_ThreeSumClosest {
    ThreeSumClosest obj = new ThreeSumClosest();
    @Test
    public void test() {
        int[] input = {-1, 0, 1, 2, -1, -4};
        int target = 0;
        int actual = obj.threeSumClosest(input, target);
        int expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    public void test1() {
        int[] input = {-1, 1, 2,  -4};
        int target = 1;
        int actual = obj.threeSumClosest(input, target);
        int expected = 2;
        assertEquals(expected, actual);
    }
}
