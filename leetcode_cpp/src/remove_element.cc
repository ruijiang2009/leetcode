/*
 * remove_element.cc
 *
 *  Created on: Nov 17, 2014
 *      Author: ruijiang
 */

#include "remove_element.h"

int Solution::removeElement(int A[], int n, int elem) {
    int j = 0;
    for(int i = 0; i < n; i++) {
        if(A[i] == elem) {
            continue;
        } else {
            A[j] = A[i];
            j++;
        }
    }

    return j;
}


