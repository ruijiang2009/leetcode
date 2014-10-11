package com.programapprentice.app;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertArrayEquals;

/**
 * @author rjiang
 * @date 10/10/14
 */
public class Test_NextPermutation {
    NextPermutation obj = new NextPermutation();

    @Test
    public void test1() {
        int[] input = {1,2,3};
        int[] expected = {1,3,2};
        obj.nextPermutation(input);
        assertArrayEquals(expected, input);
    }

    @Test
    public void test2() {
        int[] input = {3,2,1};
        int[] expected = {1,2,3};
        obj.nextPermutation(input);
        assertArrayEquals(expected, input);
    }

    @Test
    public void test3() {
        int[] input = {1,1,5};
        int[] expected = {1,5,1};
        obj.nextPermutation(input);
        assertArrayEquals(expected, input);
    }

}
