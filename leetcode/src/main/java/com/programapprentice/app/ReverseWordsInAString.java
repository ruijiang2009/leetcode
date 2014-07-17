package com.programapprentice.app;

/**
 * @author rjiang
 * @date 7/17/14
 */

/**
 * Given an input string, reverse the string word by word.
 * For example,
 * Given s = "the sky is blue",
 * return "blue is sky the".
 *
 * Clarification:
 * What constitutes a word?
 *  A sequence of non-space characters constitutes a word.
 * Could the input string contain leading or trailing spaces?
 *  Yes. However, your reversed string should not contain leading or trailing spaces.
 * How about multiple spaces between two words?
 *  Reduce them to a single space in the reversed string.
 * */



public class ReverseWordsInAString {
    public String reverseWords(String s) {
        s = s.trim();
        StringBuilder sb = new StringBuilder();
        int begIndex = 0;
        int endIndex = s.length();

        for(int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                if (s.charAt(endIndex - 1) != ' ') {
                    begIndex = i;
                    if (!sb.toString().equals("")) {
                        sb.append(' ');
                    }
                    sb.append(s.substring(begIndex + 1, endIndex));
                    endIndex = begIndex;
                } else {
                    endIndex --;
                }
            } else {
                if(i == 0) {
                    if(!sb.toString().equals("")) {
                        sb.append(' ');
                    }
                    sb.append(s.substring(i, endIndex));
                }
            }
        }

        return sb.toString();
    }
}
