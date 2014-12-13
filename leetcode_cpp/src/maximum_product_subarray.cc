/*
 * maximum_product_subarray.cc
 *
 *  Created on: Dec 10, 2014
 *      Author: ruijiang
 */

#include <climits>
#include "maximum_product_subarray.h"
#include <iostream>

using namespace::std;

int Solution::max3(int a, int b, int c) {
    int m = a > b ? a : b;
    m = m > c ? m : c;
    return m;
}

int Solution::min3(int a, int b, int c) {
    int m = a > b ? b : a;
    m = m > c ? c : m;
    return m;
}

int Solution::maxProduct(int A[], int n) {
    if(0 == n) {
        return 0;
    }
    int min = A[0];
    int max = A[0];
    int tmin = min, tmax = max;
    int global_max = A[0];
    int tmp1, tmp2;
    for(int i = 1; i < n; i++) {
        tmp1 = min * A[i];
        tmp2 = max * A[i];
//        cout << "tmp1 " << tmp1 << " tmp2 " << tmp2 << " A[i] " << A[i] << endl;
        min = min3(tmp1, tmp2, A[i]);
        max = max3(tmp1, tmp2, A[i]);
        global_max = global_max > max ? global_max : max;
//        cout << "min: " << min << " max: " << max << " global max " << global_max << endl;
    }
    return global_max;
}
