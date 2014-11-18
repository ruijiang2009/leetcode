/*
 * remove_duplicates_from_sorted_array.cc
 *
 *  Created on: Nov 17, 2014
 *      Author: ruijiang
 */

#include "remove_duplicates_from_sorted_array.h"

int Solution::removeDuplicates(int A[], int n) {
    if(0 == n || 1 == n) {
        return n;
    }
    int j = 0;
    for(int i = 1; i < n; i++) {
        if(A[i] != A[j]) {
            A[j + 1] = A[i];
            j++;
        }
    }
    return j + 1;
}
