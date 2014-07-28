package com.programapprentice.app;

/**
 * @author rjiang
 * @date 7/24/14
 */

/**
 * Validate if a given string is numeric.

 Some examples:
 "0" => true
 " 0.1 " => true
 "abc" => false
 "1 a" => false
 "2e10" => true
 Note: It is intended for the problem statement to be ambiguous. You should gather all requirements up front before implementing one.
 */
public class ValidNumber {
    public static boolean isNumber(String s) {
        s = s.trim();
        if(s.equals("")) {
            return false;
        }
        String subStrs = s.split(".");

        boolean hasDot = false;
        boolean hasE = false;
        boolean hasNumber = false;
        for(int i = 0; i < s.length(); i++) {
            if(isNumber(s.charAt(i))) {
                hasNumber = true;
                continue;
            } else if(s.charAt(i) == '.') {
                if(!hasDot) {
                    if(hasE && !hasNumber) {
                        return false;
                    }
                    hasDot = true;
                    hasNumber = false;
                } else {
                    return false;
                }
            } else if(s.charAt(i) == 'e') {
                if(!hasE) {
                    if(!hasNumber) {
                        return false;
                    }
                    hasE = true;
                    hasNumber = false;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
//        if(hasDot && !hasNumber) {
//            return false;
//        }
        if(hasE && !hasNumber) {
            return false;
        }

        return true;
    }

    public static boolean isNumberWithoutDoc(String str) {


    }


    public static boolean isNumber(char c) {
        if (c >= '0' && c <= '9') {
            return true;
        }
        return false;
    }
}
