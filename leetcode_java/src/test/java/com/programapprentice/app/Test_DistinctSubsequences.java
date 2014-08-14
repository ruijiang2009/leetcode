package com.programapprentice.app;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author rjiang
 * @date 8/14/14
 */
public class Test_DistinctSubsequences {
    DistinctSubsequences obj = new DistinctSubsequences();

    @Test
    public void test1() {
        String s = "rabbbit";
        String t = "rabbit";
        long start = System.currentTimeMillis();
        int output = obj.numDistinct(s, t);
        long end = System.currentTimeMillis();
        System.out.println((end - start) + "ms");
        int expected = 3;
        assertEquals(expected, output);
    }

    @Test
    public void test2() {
        String s = "daacaedaceacabbaabdccdaaeaebacddadcaeaacadbceaecddecdeedcebcdacdaebccdeebcbdeaccabcecbeeaadbccbaeccbbdaeadecabbbedceaddcdeabbcdaeadcddedddcececbeeabcbecaeadddeddccbdbcdcbceabcacddbbcedebbcaccac";
        String t =  "ceadbaa";
        long start = System.currentTimeMillis();
        int output = obj.numDistinct(s, t);
        long end = System.currentTimeMillis();
        System.out.println((end - start) + "ms");
        int expected = 8556153;
        assertEquals(expected, output);
    }

    @Test
    public void test3() {
        String s = "arr";
        String t =  "srr";
        int output = obj.numDistinct(s, t);
        int expected = 0;
        assertEquals(expected, output);
    }

    @Test
    public void test4() {
        String s = "rrr";
        String t =  "rr";
        int output = obj.numDistinct(s, t);
        int expected = 3;
        assertEquals(expected, output);
    }

    @Test
    public void test5() {
        String s = "ccc";
        String t =  "c";
        int output = obj.numDistinct(s, t);
        int expected = 3;
        assertEquals(expected, output);
    }

    @Test
    public void test6() {
        String s = "b";
        String t =  "a";
        int output = obj.numDistinct(s, t);
        int expected = 0;
        assertEquals(expected, output);
    }
}

