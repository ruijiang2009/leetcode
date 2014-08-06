package com.programapprentice.app;

/**
 * Created with IntelliJ IDEA.
 * User: ruijiang
 * Date: 8/2/14
 * Time: 6:37 PM
 */
/**
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 *
 * For example,
 * "A man, a plan, a canal: Panama" is a palindrome.
 * "race a car" is not a palindrome.
 *
 * Note:
 * Have you consider that the string might be empty? This is a good question to ask during an interview.
 *
 * For the purpose of this problem, we define empty string as valid palindrome.
 * */

public class ValidPalindrome {

    public boolean isAlphaNumeric(char c) {
        if ((c >= '0' && c <= '9') || (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
            return true;
        }
        return false;
    }

    public boolean isNumber(char c) {
        return c >= '0' && c <= '9';
    }

    public boolean isEqualsIgnoreCase(char a, char b) {
        if(isNumber(a) && isNumber(b)) {
            return a == b;
        }
        return Character.toLowerCase(a) == Character.toLowerCase(b);
    }

    public boolean isPalindrome(String s) {
        if(s == null || s.length() == 1) {
            return true;
        }
        int start = 0;
        int end = s.length()-1;
        while(start <= end) {
            if(isAlphaNumeric(s.charAt(start)) && isAlphaNumeric(s.charAt(end))) {
                if(!isEqualsIgnoreCase(s.charAt(start), s.charAt(end))) {
                    return false;
                }
                start++;
                end--;
            } else {
                if(!isAlphaNumeric(s.charAt(start))) {
                    start++;
                }
                if(!isAlphaNumeric(s.charAt(end))) {
                    end--;
                }
            }
        }

        return true;
    }

}
