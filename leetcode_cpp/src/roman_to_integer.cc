/*
 * roman_to_integer.cc
 *
 *  Created on: Nov 18, 2014
 *      Author: ruijiang
 */

#include "roman_to_integer.h"

int Solution::dict(char c) {
    switch(c) {
    case 'I':
        return 1;
    case 'V':
        return 5;
    case 'X':
        return 10;
    case 'L':
        return 50;
    case 'C':
        return 100;
    case 'D':
        return 500;
    case 'M':
        return 1000;
    }
    return 1;
}

int Solution::romanToInt(string s) {
    int length = s.length();
    if(0 == length) {
        return 0;
    }
    int result = dict(s[length - 1]);
    for(int i = length - 2; i >= 0; i--) {
        if(dict(s[i]) < dict(s[i + 1])) {
            result -= dict(s[i]);
        } else {
            result += dict(s[i]);
        }
    }
    return result;
}
