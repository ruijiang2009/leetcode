/*
 * roman_to_integer_test.cc
 *
 *  Created on: Nov 18, 2014
 *      Author: ruijiang
 */

#include "roman_to_integer.h"
#include "gtest/gtest.h"

TEST(RomanToInteger, One) {
    Solution obj;
    string s("XLIX");
    int expected = 49;
    int actual = obj.romanToInt(s);
    EXPECT_EQ(expected, actual);
}

TEST(RomanToInteger, Two) {
    Solution obj;
    string s("XXXIII");
    int expected = 33;
    int actual = obj.romanToInt(s);
    EXPECT_EQ(expected, actual);
}

