package com.programapprentice.app;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author rjiang
 * @date 8/7/14
 */
public class Test_LongestConsecutiveSequence {
    LongestConsecutiveSequence obj = new LongestConsecutiveSequence();
    @Test
    public void test1() {
        int[] input = {100, 4, 200, 1, 3, 2};
        int expected = 4;
        int output = obj.longestConsecutive(input);
        assertEquals(expected, output);
    }

    @Test
    public void test2() {
        int[] input =  {0,0,1,-1};
        int expected = 3;
        int output = obj.longestConsecutive(input);
        assertEquals(expected, output);
    }
}
