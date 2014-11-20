/*
 * zigzag_conversion.cc
 *
 *  Created on: Nov 19, 2014
 *      Author: rjiang
 */

#include "zigzag_conversion.h"
#include <iostream>

string Solution::convert(string s, int nRows) {
    if(1 == nRows) {
        return s;
    }
    string result("");
    int index = 0;
    for(int i = 0; i < nRows; i++) {
        index = i;
        if(i == 0 || i == nRows - 1) {
            while(index < s.length()) {
                result.push_back(s[index]);
                index += nRows + nRows - 2;
            }
        } else {
            bool oddCol = true;
            while(index < s.length()) {
                result.push_back(s[index]);
                if(oddCol) {
                    index += nRows - i - 1 + nRows - i - 1;
                    oddCol = false;
                } else {
                    index += i + i;
                    oddCol = true;
                }
            }
        }
    }

    return result;
}

// from java version
//string Solution::convert(string s, int nRows) {
//    if(1 == nRows) {
//        return s;
//    }
//    string sb("");
//    int cur = 0;
//    for(int row = 1; row <= nRows; row++) {
//        cur = row - 1;
//        if(row == 1 || row == nRows) {
//            while(cur < s.length()) {
//                sb.push_back(s[cur]);
//                cur += nRows + nRows - 2;
//            }
//        } else {
//            while(cur < s.length()) {
//                sb.push_back(s[cur]);
//                int tmpCur = cur + nRows + nRows - row - row;
//                if(tmpCur < s.length()) {
//                    sb.push_back(s[tmpCur]);
//                } else {
//                    break;
//                }
//                cur += nRows + nRows - 2;
//            }
//        }
//    }
//    return sb;
//}
