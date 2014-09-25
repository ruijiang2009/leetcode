package com.programapprentice.app;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * @author rjiang
 * @date 9/25/14
 */
public class Test_FirstMissingPositive {
    FirstMissingPositive obj = new FirstMissingPositive();

    @Test
    public void test1() {
        int[] input = {1,2,0};
        int expected = 3;
        int actual = obj.firstMissingPositive(input);
        assertEquals(expected, actual);
    }

    @Test
    public void test2() {
        int[] input = {3,4,-1,1};
        int expected = 2;
        int actual = obj.firstMissingPositive(input);
        assertEquals(expected, actual);
    }

    @Test
    public void test3() {
        int[] input = {1};
        int expected = 2;
        int actual = obj.firstMissingPositive(input);
        assertEquals(expected, actual);
    }

    @Test
    public void test4() {
        int[] input = {-3,9,16,4,5,16,-4,9,26,2,1,19,-1,25,7,22,2,-7,14,2,5,-6,1,17,3,24,-4,17,15};
        int expected = 6;
        int actual = obj.firstMissingPositive(input);
        assertEquals(expected, actual);
    }


    @Test
    public void test5() {
        int[] input = {99,94,96,11,92,5,91,89,57,85,66,63,84,81,79,61,74,78,77,30,64,13,58,18,70,69,51,12,32,34,9,43,39,8,1,38,49,27,21,45,47,44,53,52,48,19,50,59,3,40,31,82,23,56,37,41,16,28,22,33,65,42,54,20,29,25,10,26,4,60,67,83,62,71,24,35,72,55,75,0,2,46,15,80,6,36,14,73,76,86,88,7,17,87,68,90,95,93,97,98};
        int expected = 100;
        int actual = obj.firstMissingPositive(input);
        assertEquals(expected, actual);
    }
}
