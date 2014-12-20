/*
 * single_number_ii.cc
 *
 *  Created on: Dec 19, 2014
 *      Author: ruijiang
 */

#include "single_number_ii.h"

/** idea
 * each integer is 32 bits
 * for those 32 bits, find each bits which show time is 1
 * after MOD 3
*/
int Solution::singleNumberII(int A[], int n) {
    if(0 == n) {
        return 0;
    }
    int bits[32];
    for(int i = 0; i < 32; i++) {
        bits[i] = 0;
    }
    int cur;
    for(int i = 0; i < n; i++) {
        cur = A[i];
        for(int j = 0; j < 32; j++) {
            bits[j] += cur & 1;
            cur = cur >> 1;
        }
    }
    int result = 0;
    for(int i = 0; i < 32; i++) {
        bits[i] = bits[i] % 3;
        result += bits[i] == 1 ? (1 << i): 0;
    }
    return result;
}
