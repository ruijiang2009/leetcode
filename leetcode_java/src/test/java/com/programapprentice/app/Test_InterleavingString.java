package com.programapprentice.app;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * @author rjiang
 * @date 8/19/14
 */
public class Test_InterleavingString {
    InterleavingString obj = new InterleavingString();

    @Test
    public void test1() {
        String s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "aadbbcbcac";
        boolean output = obj.isInterleave(s1, s2, s3);
        boolean expected = true;
        assertEquals(expected, output);
    }

    @Test
    public void test2() {
        String s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "aadbbbaccc";
        boolean output = obj.isInterleave(s1, s2, s3);
        boolean expected = false;
        assertEquals(expected, output);
    }

    @Test
    public void test3() {
        String s1 = "a";
        String s2 = "";
        String s3 = "a";
        boolean output = obj.isInterleave(s1, s2, s3);
        boolean expected = true;
        assertEquals(expected, output);
    }

    @Test
    public void test4() {
        String s1 = "";
        String s2 = "";
        String s3 = "";
        boolean output = obj.isInterleave(s1, s2, s3);
        boolean expected = true;
        assertEquals(expected, output);
    }

    @Test
    public void test5() {
        String s1 = "abbbbbbcabbacaacccababaabcccabcacbcaabbbacccaaaaaababbbacbb";
        String s2 = "ccaacabbacaccacababbbbabbcacccacccccaabaababacbbacabbbbabc";
        String s3 = "cacbabbacbbbabcbaacbbaccacaacaacccabababbbababcccbabcabbaccabcccacccaabbcbcaccccaaaaabaaaaababbbbacbbabacbbacabbbbabc";
        boolean output = obj.isInterleave(s1, s2, s3);
        boolean expected = true;
        assertEquals(expected, output);
    }
}
