package com.programapprentice.app;

/**
 * Created with IntelliJ IDEA.
 * User: ruijiang
 * Date: 10/2/14
 * Time: 7:12 PM
 */

/**
 * '?' Matches any single character.
 * '*' Matches any sequence of characters (including the empty sequence).
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
 * isMatch("aa", "*") → true
 * isMatch("aa", "a*") → true
 * isMatch("ab", "?*") → true
 * isMatch("aab", "c*a*b") → false
 */
public class WildcardMatching {
    public boolean isMatch(String s, String p) {
        if(p == null || s == null) {
            return false;
        }
        if(p.length() == 0) {
            if(s.length() == 0) {
                return true;
            } else {
                return false;
            }
        }
        int j = 0;
        for(int i = 0; i < s.length(); i++) {
            if(p.charAt(j) == '?') {
                j++;
                continue;
            } if(p.charAt(j) == '*') {
                continue;
            } else {
                if(p.charAt(j) == s.charAt(i)) {
                    j++;
                    if(j == p.length() && i < s.length() - 1) {
                        return false;
                    }
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
