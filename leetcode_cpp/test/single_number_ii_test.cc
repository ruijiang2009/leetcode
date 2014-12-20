/*
 * single_number_ii_test.cc
 *
 *  Created on: Dec 19, 2014
 *      Author: ruijiang
 */

#include "gtest/gtest.h"
#include "single_number_ii.h"

TEST(SingleNumberII, One) {
    Solution obj;
    int A[] = {1, 2, 4, 1, 2, 1, 2};
    int expected = 4;
    int actual = obj.singleNumberII(A, 7);
    EXPECT_EQ(expected, actual);
}
