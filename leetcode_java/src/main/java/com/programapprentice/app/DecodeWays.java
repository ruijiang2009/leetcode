package com.programapprentice.app;

/**
 * @author rjiang
 * @date 8/26/14
 */
public class DecodeWays {
    public int numDecodings(String s) {
        if(s == null || s.length() == 0 || s.startsWith("0")) {
            return 0;
        }
        if(s.length() == 1) {
            return 1;
        }
        int[] record = new int[s.length()];
        if(s.charAt(0) == '0') {
            record[0] = 0;
        } else {
            record[0] = 1;
        }
        String tmp = null;
        for(int i = 1; i < s.length(); i++) {
            if(s.charAt(i) == '0') {
                if(s.charAt(i-1) == '0' || s.charAt(i-1) >= '3') {
                    record[s.length() - 1] = 0;
                    break;
                } else {
                    if(i-2 >= 0) {
                        record[i] = record[i-2];
                    } else {
                        record[i] = 1;
                    }
                }
            } else {
                tmp = s.substring(i - 1, i + 1);
                if (Integer.valueOf(tmp) <= 26 && Integer.valueOf(tmp) >= 11) {
                    if(i-2 >= 0) {
                        record[i] = record[i - 1] + record[i - 2];
                    } else {
                        record[i] = record[i - 1] + 1;
                    }
                } else {
                    record[i] = record[i - 1];
                }
            }
        }
        return record[s.length() - 1];
    }

    public int numDecodings2(String s) {
        if(s == null || s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }
        if(s.length() == 1) {
            return 1;
        }
        int n = s.length();
        int result[] = new int[n + 1];
        result[0] = 1;
        result[1] = 1;
        int value = 0;

        for(int i = 2; i <= n; i++) {
            if(s.charAt(i-1) != '0') {
                result[i] = result[i-1];
            }
            if(s.charAt(i-2) != '0') {
                value = (s.charAt(i-2) - '0') * 10 + (s.charAt(i-1) - '0');
                if(value > 0 && value <= 26) {
                    result[i] += result[i-2];
                }
            }
        }
        return result[n];
    }
}
