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
    public boolean isNumber(char c) {
        if (c >= '0' && c <= '9') {
            return true;
        }
        return false;
    }

    public boolean doesContainOperator(String s) {
        if (s.contains("+") || s.contains("-")) {
            return true;
        }
        return false;
    }

    public boolean isNumber(String s) {
        s = s.trim();
        if(s.isEmpty()) {
            return false;
        }

        String left = null;
        String right = null;
        if(s.contains("e")) {
            int index = s.indexOf('e');
            left = s.substring(0, index);
            right = s.substring(index+1);
        } else if(s.contains("E")) {
            int index = s.indexOf('E');
            left = s.substring(0, index);
            right = s.substring(index+1);
        } else {
            return isLeftNumber(s);
        }
        if(left.equals("") || right.equals("")) {
            return false;
        }

        if (isLeftNumber(left) && isRightNumber(right)) {
            return true;
        }
        return false;
    }

    public boolean isLeftNumber(String s) {
        if(s.equals("")) {
            return false;
        }
        if(s.charAt(0) == '-' || s.charAt(0) == '+' ) {
            s = s.substring(1);
            if(s.equals("")) {
                return false;
            }
        }
        boolean hasDot = false;
        boolean hasLeftNumber = false;
        boolean hasRightNumber = false;
        for(int i = 0; i < s.length(); i++) {
            if(isNumber(s.charAt(i))) {
                if(hasDot) {
                    hasRightNumber = true;
                } else {
                    hasLeftNumber = true;
                }
            } else if(s.charAt(i) == '.') {
                if(!hasDot) {
                    hasDot = true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
        if(hasDot) {
            if(hasLeftNumber || hasRightNumber) {
                return true;
            } else {
                return false;
            }
        }
        return true;
    }

    public boolean isRightNumber(String s) {
        if(s.equals("")) {
            return false;
        }
        if(s.charAt(0) == '-' || s.charAt(0) == '+' ) {
            s = s.substring(1);
            if(s.equals("")) {
                return false;
            }
        }
        boolean hasNumber = false;
        for(int i = 0; i < s.length(); i++) {
            if(isNumber(s.charAt(i))) {
                hasNumber = true;
            } else {
                return false;
            }
        }
        return true;
    }

}
