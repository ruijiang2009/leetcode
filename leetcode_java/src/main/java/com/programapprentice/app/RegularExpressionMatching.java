package com.programapprentice.app;

/**
 * @author rjiang
 * @date 10/17/14
 */

/**
 * Implement regular expression matching with support for '.' and '*'.
 *
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 *
 * The matching should cover the entire input string (not partial).
 *
 * The function prototype should be:
 * bool isMatch(const char *s, const char *p)
 *
 * Some examples:
 * isMatch("aa","a") → false
 * isMatch("aa","aa") → true
 * isMatch("aaa","aa") → false
 * isMatch("aa", "a*") → true
 * isMatch("aa", ".*") → true
 * isMatch("ab", ".*") → true
 * isMatch("aab", "c*a*b") → true
 * */

// good reference
public class RegularExpressionMatching {
    // failed
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) return false;
        if(p.length() == 0) {
            if(s.length() == 0) {
                return true;
            } else {
                return false;
            }
        }
        int sPos = 0;
        int pPos = 0;
        char charPreStart = 0;

        while(sPos < s.length()) {
            if(pPos < p.length()
                    && (s.charAt(sPos) == p.charAt(pPos) || p.charAt(pPos) == '.')) {
                charPreStart = p.charAt(pPos);
                sPos++;
                pPos++;
            } else if(pPos < p.length() && p.charAt(pPos) == '*') {
                if(s.charAt(sPos) == charPreStart || charPreStart == '.') {
                    sPos++;
                } else {
                    pPos++;
                }
            } else {
                if(pPos+1 < p.length() && p.charAt(pPos+1) == '*') {
                    sPos++;
                    pPos += 2;
                } else {
                    return false;
                }
            }
        }

        while(pPos < p.length()) {
            if(p.charAt(pPos) == '*') {
                pPos++;
            } else if(pPos + 1 < p.length()) {
                if(p.charAt(pPos+1) == '*') {
                    pPos += 2;
                    continue;
                } else {
                    break;
                }
            } else {
                break;
            }
        }

        return sPos == s.length() && pPos == p.length();

    }

    public boolean isMatch(String s, String p) {
        if (s == null || p == null) return false;
        if(p.length() == 0) {
            if(s.length() == 0) {
                return true;
            } else {
                return false;
            }
        }

    }
}
