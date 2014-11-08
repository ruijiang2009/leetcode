/*
 * reverse_integer.cc
 *
 *  Created on: Nov 7, 2014
 *      Author: ruijiang
 */

#include "reverse_integer.h"

int Solution::reverse(int x) {
    if(x == 0) {
            return x;
    }
    bool is_neg = false;
    long target;
    if(x < 0) {
        is_neg = true;
        target = 0 - x;
    } else {
        target = x;
    }
    long result = 0;
    long mod = 0;

    while(target / 10L != 0) {
        mod = target % 10;
        target = target / 10;
        if(0 == result) {
            result += mod;
        } else {
            result = result * 10L + mod;
        }
    }
    result = result * 10L + target;
    if(is_neg) {
        result = 0 - result;
    }
    return (int)result;
}
