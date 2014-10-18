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

// good reference http://leetcode.com/2011/09/regular-expression-matching.html
public class RegularExpressionMatching {
    /** Use recursion
     * If the next character of p is NOT ‘*’, then it must match the current character of s.
     * Continue pattern matching with the next character of both s and p.
     * If the next character of p is ‘*’, then we do a brute force exhaustive matching
     * of 0, 1, or more repeats of current character of p…
     * Until we could not match any more characters.
     * */
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) return false;
        if(p.length() == 0) {
            if(s.length() == 0) {
                return true;
            } else {
                return false;
            }
        }
        if(p.length() == 1) {
            return s.length() == 1 && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.');
        }
        if(p.charAt(1) != '*') {
            if(s.length() == 0) {
                return false;
            }
            if(s.charAt(0) == p.charAt(0) || p.charAt(0) == '.') {
                return isMatch(s.substring(1), p.substring(1));
            } else {
                return false;
            }
        } else {
            int sPos = -1;
            while(sPos < s.length() && (sPos < 0 || p.charAt(0) == '.' || p.charAt(0) == s.charAt(sPos))) {
                if (isMatch(s.substring(sPos + 1), p.substring(2))) {
                    return true;
                }
                sPos++;
            }
            return false;
        }
    }
}
