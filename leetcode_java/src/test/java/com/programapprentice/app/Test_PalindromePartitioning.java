package com.programapprentice.app;

import org.junit.Test;

import java.util.List;

/**
 * @author rjiang
 * @date 8/11/14
 */
public class Test_PalindromePartitioning {
    PalindromePartitioning obj = new PalindromePartitioning();
    @Test
    public void test1() {
        String input = "aab";
        List<List<String>> output = obj.partition(input);
        for(List<String> l : output) {
            for(String s : l) {
                System.out.print(s + ", ");
            }
            System.out.println("");
        }
    }

    @Test
    public void test2() {
        String input = "aba";
        List<List<String>> output = obj.partition(input);
        for(List<String> l : output) {
            for(String s : l) {
                System.out.print(s + ", ");
            }
            System.out.println("");
        }
    }

    @Test
    public void test3() {
        String input = "abab";
        List<List<String>> output = obj.partition(input);
        for(List<String> l : output) {
            for(String s : l) {
                System.out.print(s + ", ");
            }
            System.out.println("");
        }
    }

    @Test
    public void test4() {
        String input = "ababa";
        List<List<String>> output = obj.partition(input);
        for(List<String> l : output) {
            for(String s : l) {
                System.out.print(s + ", ");
            }
            System.out.println("");
        }
    }

    @Test
    public void test5() {
        String input = "seeslaveidemonstrateyetartsnomedievalsees";
        List<List<String>> output = obj.partition(input);
        for(List<String> l : output) {
            for(String s : l) {
                System.out.print(s + ", ");
            }
            System.out.println("");
        }
    }

    @Test
    public void test6() {
        String input = "ababababababababababababcbabababababababababababa";
        List<List<String>> output = obj.partition(input);
        for(List<String> l : output) {
            for(String s : l) {
                System.out.print(s + ", ");
            }
            System.out.println("");
        }
    }

    @Test
    public void test7() {
        String input = "aabbaaa";
        List<List<String>> output = obj.partition(input);
        for(List<String> l : output) {
            for(String s : l) {
                System.out.print(s + ", ");
            }
            System.out.println("");
        }
    }
}

