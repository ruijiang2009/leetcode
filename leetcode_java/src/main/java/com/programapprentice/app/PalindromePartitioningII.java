package com.programapprentice.app;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author rjiang
 * @date 8/13/14
 */
public class PalindromePartitioningII {
    public boolean isPalindrome(String s) {
        if(s == null || s.length() <= 1) {
            return true;
        }
        int mid = s.length() / 2;
        for(int i = 0; i < mid; i++) {
            if(s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    // find all the palindrome from right to left from startindex (include startindex)
    public List<Integer> findPalindromes(String input, int startIndex) {
        List<Integer> output = new ArrayList<Integer>();
        for(int i = startIndex; i >= 0; i--) {
            if(isPalindrome(input.substring(i, startIndex + 1))) {
                output.add(i);
            }
        }
        return output;
    }

    public List<Integer> findPalindromes(String input, int startIndex, boolean[][] isPalindrome) {
        char startChar = input.charAt(startIndex);
        List<Integer> output = new ArrayList<Integer>();
        for(int i = 0; i < startIndex; i++) {
            if(input.charAt(i) != startChar) {
                continue;
            } else {
                if(i == startIndex-1) {
                    output.add(i);
                    isPalindrome[i][startIndex] = true;
                    isPalindrome[startIndex][i] = true;
                } else {
                    if (isPalindrome[i + 1][startIndex - 1]) {
                        output.add(i);
                    }
                }
            }
        }
        output.add(startIndex); // adding itself.
        return output;
    }

    // use DP
    public int minCut(String s) {
        if(s == null || s.length() == 1) {
            return 0;
        }
        int[] cuts = new int[s.length()]; // save the minCut for s.subString(0, i+1)
        boolean[][] isPalindrome = new boolean[s.length()][s.length()];
        isPalindrome[0][0] = true;

        cuts[0] = 0;
        for(int i = 1; i < s.length(); i++) {
            isPalindrome[i][i] = true;
            cuts[i] = s.length();
            List<Integer> indexes = findPalindromes(s, i, isPalindrome);
            for(Integer integer : indexes) {
                isPalindrome[integer][i] = true;
                isPalindrome[i][integer] = true;
                if(integer == 0) {
                    cuts[i] = 0;
                } else {
                    cuts[i] = cuts[i] > cuts[integer-1] + 1 ? cuts[integer-1] + 1 : cuts[i];
                }
            }
            if(indexes.isEmpty()) {
                cuts[i] = cuts[i - 1] + 1;
            }
        }

        return cuts[s.length()-1];
    }

}
