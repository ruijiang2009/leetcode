/*
 * zigzag_conversion.cc
 *
 *  Created on: Nov 19, 2014
 *      Author: rjiang
 */

#include "zigzag_conversion.h"

string Solution::convert(string s, int nRows) {
    string result;
    int index = 0;
    for(int i = 0; i < nRows; i++) {
        index = i;
        if(i % 2 == 0) {
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
