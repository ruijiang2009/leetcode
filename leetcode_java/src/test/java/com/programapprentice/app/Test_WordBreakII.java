package com.programapprentice.app;

import org.junit.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;

/**
 * @author rjiang
 * @date 7/28/14
 */
public class Test_WordBreakII {
    @Test
    public void test1() {
        String[] strs = {"leet", "code"};
        Set<String> dict = new HashSet<String>();
        for(String s : strs) {
            dict.add(s);
        }

        List<String> output = WordBreakII.wordBreak("leetcode", dict);
        for(String s : output) {
            System.out.println(s);
        }
    }

    @Test
    public void test2() {
        String[] strs = {"lee", "leet", "code", "tcode"};
        Set<String> dict = new HashSet<String>();
        for(String s : strs) {
            dict.add(s);
        }

        List<String> output = WordBreakII.wordBreak("leetcode", dict);
        for(String s : output) {
            System.out.println(s);
        }
    }

    @Test
    public void test3() {
        String[] strs = {"lee", "leetc", "code"};
        Set<String> dict = new HashSet<String>();
        for(String s : strs) {
            dict.add(s);
        }

        boolean output = WordBreak.wordBreak("leetcode", dict);
        assertEquals(false, output);
    }

    @Test
    public void test4() {
        String[] strs = {"a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"};
        Set<String> dict = new HashSet<String>();
        for(String s : strs) {
            dict.add(s);
        }
        String input = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
        System.out.println("input length " + input.length());
        List<String> output = WordBreakII.wordBreak(input, dict);
        System.out.println("output size " + output.size());
        for(String s : output) {
            System.out.println(s);
        }
    }

    @Test
    public void test5() {
        String[] strs = {"aaaa","aa","a"};
        Set<String> dict = new HashSet<String>();
        for(String s : strs) {
            dict.add(s);
        }
        String input = "aaaaaaa";
        System.out.println("input length " + input.length());
        List<String> output = WordBreakII.wordBreak(input, dict);
        System.out.println("output size " + output.size());
        for(String s : output) {
            System.out.println(s);
        }
    }
}
