/*
 * maximum_product_subarray_test.cc
 *
 *  Created on: Dec 10, 2014
 *      Author: ruijiang
 */

#include "gtest/gtest.h"
#include "maximum_product_subarray.h"

TEST(MaximumProductSubarray, One) {
    Solution obj;
    int input[] = {2, -1, -2, -3};
    int expected = 6;
    int actual = obj.maxProduct(input, 4);
    EXPECT_EQ(expected, actual);
}

TEST(MaximumProductSubarray, Two) {
    Solution obj;
    int input[] = {2, 3, -2, 4};
    int expected = 6;
    int actual = obj.maxProduct(input, 4);
    EXPECT_EQ(expected, actual);
}

TEST(MaximumProductSubarray, Three) {
    Solution obj;
    int input[] = {2, -1, -3, -4};
    int expected = 12;
    int actual = obj.maxProduct(input, 4);
    EXPECT_EQ(expected, actual);
}

TEST(MaximumProductSubarray, Four) {
    Solution obj;
    int input[] = {0, 2};
    int expected = 2;
    int actual = obj.maxProduct(input, 2);
    EXPECT_EQ(expected, actual);
}

TEST(MaximumProductSubarray, Five) {
    Solution obj;
    int input[] = {3, -1, 4};
    int expected = 4;
    int actual = obj.maxProduct(input, 3);
    EXPECT_EQ(expected, actual);
}

TEST(MaximumProductSubarray, Six) {
    Solution obj;
    int input[] = {2,-5,-2,-4,3};
    int expected = 24;
    int actual = obj.maxProduct(input, 5);
    EXPECT_EQ(expected, actual);
}
