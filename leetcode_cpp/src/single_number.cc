#include "single_number.h"

int Solution::singleNumber(int A[], int n) {
    if(0 == n) {
        return 0;
    }
    if(1 == n) {
        return A[0];
    }
    int result = A[0];
    for(int i = 1; i < n; i++) {
        result ^= A[i];
    }
    return result;
}
