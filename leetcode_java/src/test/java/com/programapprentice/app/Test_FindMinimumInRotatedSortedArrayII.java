package com.programapprentice.app;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: ruijiang
 * Date: 1/11/15
 * Time: 5:04 PM
 */
public class Test_FindMinimumInRotatedSortedArrayII {
    FindMinimumInRotatedSortedArrayII obj = new FindMinimumInRotatedSortedArrayII();

    @Test
    public void test1() {
        int num[] = {2,2,0,0,1,1};
        int expected = 0;
        int actual = obj.findMin(num);
        assertEquals(expected, actual);
    }
}
