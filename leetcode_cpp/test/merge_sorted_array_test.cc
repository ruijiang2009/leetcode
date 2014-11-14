/*
 * merge_sorted_array_test.cc
 *
 *  Created on: Nov 12, 2014
 *      Author: ruijiang
 */

#include "merge_sorted_array.h"
#include "gtest/gtest.h"

TEST(MergeSortedArray, One) {
    int A[] = {1, 2, 3, 0};
    int m = 3;
    int B[] = {0};
    int n = 1;
    Solution obj;
    obj.merge(A, m, B, n);
    EXPECT_EQ(0, A[0]);
    EXPECT_EQ(1, A[1]);
    EXPECT_EQ(2, A[2]);
    EXPECT_EQ(3, A[3]);
}



