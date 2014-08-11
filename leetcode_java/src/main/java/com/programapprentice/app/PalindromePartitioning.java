package com.programapprentice.app;

import java.util.ArrayList;
import java.util.List;

/**
 * @author rjiang
 * @date 8/11/14
 */
public class PalindromePartitioning {
    public List<List<String>> partitionTooSlow(String s) {
        List<List<String>> output = new ArrayList<List<String>>();
        if(s == null || s.length() == 0) {
            return output;
        }
        if(s.length() == 1) {
            List<String> l  = new ArrayList<String>();
            l.add(s);
            output.add(l);
            return output;
        }
        List<List<String>> subList = partitionTooSlow(s.substring(1));
        Boolean hasPalindrome = false;
        for(List<String> l : subList) {
            List<String> newl = new ArrayList<String>(l);
            newl.add(0, String.valueOf(s.charAt(0)));
            output.add(newl);
            StringBuilder sb = new StringBuilder();
            sb.append(String.valueOf(s.charAt(0)));
            newl = new ArrayList<String>();
            hasPalindrome = false;
            for(String str : l) {
                if(hasPalindrome == false) {
                    sb.append(str);
                    if (isPalindrome(sb.toString())) {
                        hasPalindrome = true;
                        newl.add(sb.toString());
                    }
                } else {
                    newl.add(str);
                }
            }
            if(hasPalindrome) {
                output.add(newl);
            }
        }

        return output;
    }

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

    public List<List<String>> partition(String s) {

    }
}
