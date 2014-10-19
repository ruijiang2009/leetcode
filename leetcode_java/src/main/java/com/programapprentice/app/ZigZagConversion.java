package com.programapprentice.app;

/**
 * Created with IntelliJ IDEA.
 * User: ruijiang
 * Date: 9/9/14
 * Time: 7:52 PM
 */
public class ZigZagConversion {
    public String convert(String s, int nRows) {
        if(1 == nRows) {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        int cur = 0;

        for(int row = 1; row <= nRows; row++) {
            cur = row - 1;
            if(row == 1 || row == nRows) {
                while(cur < s.length()) {
                    sb.append(s.charAt(cur));
                    cur += nRows + nRows - 2;
                }
            } else {
                while(cur < s.length()) {
                    sb.append(s.charAt(cur));
                    int tmpCur = cur + nRows + nRows - row - row;
                    if(tmpCur < s.length()) {
                        sb.append(s.charAt(tmpCur));
                    } else {
                        break;
                    }
                    cur += nRows + nRows - 2;
                }
            }
        }
        return sb.toString();
    }
}
