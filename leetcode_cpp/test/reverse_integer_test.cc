/*
 * reverse_integer_test.cc
 *
 *  Created on: Nov 7, 2014
 *      Author: ruijiang
 */
#include "reverse_integer.h"
#include "gtest/gtest.h"

TEST(ReverseInteger, One) {
    Solution obj;
    int input = 123;
    int expected = 321;
    int actual = obj.reverse(input);
    EXPECT_EQ(expected, actual);
}

TEST(ReverseInteger, Two) {
    Solution obj;
    int input = -123;
    int expected = -321;
    int actual = obj.reverse(input);
    EXPECT_EQ(expected, actual);
}
