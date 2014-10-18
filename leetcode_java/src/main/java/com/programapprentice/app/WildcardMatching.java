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
        int sPos = 0;
        int starPos = -1;
        int pPos = 0;
        int sPosBak = -1;

        while(sPos < s.length()) {
            if(pPos < p.length() &&
                    (s.charAt(sPos) == p.charAt(pPos)
                     || p.charAt(pPos) == '?')) {
                pPos++;
                sPos++;
            } else if (pPos < p.length() && p.charAt(pPos) == '*') {
                starPos = pPos;
                sPosBak = sPos;
                pPos++;
                continue;
            } else if (starPos != -1) {
                sPos = sPosBak;
                pPos = starPos + 1;
                sPosBak++;
            } else {
                return false;
            }
        }

        while (pPos < p.length() && p.charAt(pPos) == '*') {
           pPos++;
        }
        return sPos == s.length() && pPos == p.length();
    }

    // http://www.programering.com/a/MTN0kzMwATU.html
    public boolean isMatchSolution(String s, String p) {
        if (s == null || p == null) return false;
        if (s.equals(p)) return true;
        int m = s.length();
        int n = p.length();
        int posS = 0;
        int posP = 0;
        int posStar = -1;
        int posOfS = -1;
        //if posS == posP || posP == '?', ++posS and ++posP.
        //posOfS, posStar, record the positon of '*' in s and p, ++posP and go on.
        //if not match, go back to star, ++posOfS
        while (posS < m) {
            if (posP < n && (s.charAt(posS) == p.charAt(posP) || p.charAt(posP) == '?')) {
                ++posS;
                ++posP;
            }
            else if (posP < n && p.charAt(posP) == '*') {
                posStar = posP;
                posOfS = posS;
                ++posP;
                continue;
            }
            else if (posStar != -1) {
                posS = posOfS;
                posP = posStar + 1;
                ++posOfS;
            }
            else {
                return false;
            }
        }
        while (posP < n && p.charAt(posP) == '*') {
            ++posP;
        }

        return posS == m && posP == n;
    }
}
