package com.programapprentice.app;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

/**
 * @author rjiang
 * @date 7/25/14
 */
public class Test_WordBreak {
    @Test
    public void test1() {
        String[] strs = {"leet", "code"};
        Set<String> dict = new HashSet<String>();
        for(String s : strs) {
            dict.add(s);
        }

        boolean output = WordBreak.wordBreak("leetcode", dict);
        assertEquals(true, output);
    }

    @Test
    public void test2() {
        String[] strs = {"lee", "leet", "code"};
        Set<String> dict = new HashSet<String>();
        for(String s : strs) {
            dict.add(s);
        }

        boolean output = WordBreak.wordBreak("leetcode", dict);
        assertEquals(true, output);
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
        boolean output = WordBreak.wordBreak(input, dict);
        assertEquals(false, output);
    }
}
