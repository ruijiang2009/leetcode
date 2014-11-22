/*
 * string_to_integer.cc
 *
 *  Created on: Nov 20, 2014
 *      Author: ruijiang
 */

#include "string_to_integer.h"
#include <climits>

int returnValue(bool isNegative, long result) {
    if(isNegative) {
        result = 0 - result;
        if(result < INT_MIN) {
            return INT_MIN;
        }
        return result;
    }
    if(result > INT_MAX) {
        return INT_MAX;
    }
    return result;
}

int Solution::atoi(const char *str) {
    int index = 0;
    long result = 0;
    bool isNegative = false;
    bool hasNonNumber = false;
    bool hasShowNumber = false;
    while(str[index] != '\0') {
        switch(str[index]) {
        case ' ':
            if(hasShowNumber) {
                return returnValue(isNegative, result);
            }
            break;
        case '+':
            if(hasNonNumber || hasShowNumber) {
                return 0;
            }
            hasNonNumber = true;
            break;
        case '-':
            if(hasNonNumber || hasShowNumber) {
                return 0;
            }
            hasNonNumber = true;
            isNegative = true;
            break;
        default:
            if(str[index] >= '0' && str[index] <= '9') {
                hasShowNumber = true;
                result = result * 10 + (str[index] - '0');
            } else {
                return returnValue(isNegative, result);
            }
        }
        index++;
    }
    return returnValue(isNegative, result);
}

// http://blog.csdn.net/ithomer/article/details/8800530
// solution:
//class Solution {
// public:
//     int atoi(const char *str) {
//         // Start typing your C/C++ solution below
//         // DO NOT write int main() function
//         assert(str != NULL);
//
//         while(isspace(*str)) str++;  // remove ' '
//
//
//         int sign = (*str == '-') ? -1 : 1;
//
//         if (*str == '-' || *str == '+')    // if can check one char
//             str++;
//
//         int ret = 0;
//         while(isdigit(*str))   // is digit
//         {
//             int digit = *str - '0';
//
//             if (INT_MAX / 10 >= ret)
//                 ret *= 10;
//             else
//                 return sign == -1 ? INT_MIN : INT_MAX;
//
//             if (INT_MAX - digit >= ret)
//                 ret += digit;
//             else
//                 return sign == -1 ? INT_MIN : INT_MAX;
//
//             str++;
//         }
//
//         return ret * sign;
//     }
// };
