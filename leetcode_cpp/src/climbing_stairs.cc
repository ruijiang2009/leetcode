/*
 * climbing_stairs.cpp
 *
 *  Created on: Nov 14, 2014
 *      Author: ruijiang
 */

#include "climbing_stairs.h"

int Solution::climbStairs(int n) {
    if(0 >= n) {
        return 0;
    }
    int result[n];
    result[0] = 1;
    result[1] = 2;
    for(int i = 2; i < n; i++) {
        result[i] = result[i-1] + result[i-2];
    }

    return result[n-1];
}


