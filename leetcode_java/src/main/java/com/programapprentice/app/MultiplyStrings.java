package com.programapprentice.app;

/**
 * Created with IntelliJ IDEA.
 * User: ruijiang
 * Date: 8/16/14
 * Time: 10:00 PM
 */

import java.util.HashMap;

/**
 * Given two numbers represented as strings, return multiplication of the numbers as a string.
 * Note: The numbers can be arbitrarily large and are non-negative.
 * */
public class MultiplyStrings {
    public String multiply(String num1, String num2) {
        String left, right;
        if(num1.length() > num2.length()) {
            left = num1;
            right = num2;
        } else {
            left = num2;
            right = num1;
        }
        HashMap<Integer, String> hashMap = new HashMap<Integer, String>();
        String output = "0";
        String tmp = null;
        String zeroString = "";

        for(int i = right.length()-1; i >= 0; i--) {
            if(right.charAt(i) != '0') {
                tmp = hashMap.get(right.charAt(i) - '0');
                if (tmp != null) {
                    tmp += zeroString;
                    output = add(output, tmp);
                } else {
                    tmp = multiply(left, right.charAt(i));
                    hashMap.put(right.charAt(i) - '0', tmp);
                    output = add(output, tmp + zeroString);
                }

            }
            zeroString += "0";
        }
        return output;
    }

    public String add(String num1, String num2) {
        String left, right;
        if(num1.length() > num2.length()) {
            left = num1;
            right = num2;
        } else {
            left = num2;
            right = num1;
        }
        String output = "";
        int carry = 0;
        int tmp = 0;

        for(int i = 1; i <= right.length(); i++) {
            tmp = left.charAt(left.length() - i) - '0' + right.charAt(right.length() - i) - '0' + carry;
            carry = tmp / 10;
            tmp = tmp % 10;
            output = String.valueOf(tmp) + output;
        }

        for(int i = right.length() + 1; i <= left.length(); i++) {
            tmp = left.charAt(left.length() - i) - '0' + carry;
            carry = tmp / 10;
            tmp = tmp % 10;
            output = String.valueOf(tmp) + output;
        }
        if(carry == 1) {
            output = String.valueOf(carry) + output;
        }

        return output;
    }

    public String multiply(String num, char oneChar) {
        int carry = 0;
        int tmp = 0;
        int right = oneChar - '0';
        if(right == 0) {
            return "0";
        }
        String output = "";
        for(int i = num.length() - 1; i >= 0; i--) {
            tmp = (num.charAt(i) - '0') * right + carry;
            carry = tmp / 10;
            tmp = tmp % 10;
            output = String.valueOf(tmp) + output;
        }
        if(carry > 0) {
            output = String.valueOf(carry) + output;
        }
        return output;
    }
}
