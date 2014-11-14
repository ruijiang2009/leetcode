/*
 * merge_sorted_array.cc
 *
 *  Created on: Nov 12, 2014
 *      Author: ruijiang
 */

#include "merge_sorted_array.h"

void Solution::merge(int A[], int m, int B[], int n) {
    int pa = m-1;
    int pb = n-1;
    int pc = m + n - 1;

    while(pa >= 0 && pb >= 0) {
        if(A[pa] > B[pb]) {
            A[pc] = A[pa];
            pa--;
        } else if (A[pa] < B[pb]) {
            A[pc] = B[pb];
            pb--;
        } else {
            A[pc] = A[pa];
            pa--;
            pc--;
            A[pc] = B[pb];
            pb--;
        }
        pc--;
    }
    if(pb >= 0) {
        while(pc >= 0) {
            A[pc] = B[pb];
            pc--;
            pb--;
        }
    }
}
