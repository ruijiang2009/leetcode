/*
 * palindrome_number_test.cc
 *
 *  Created on: Nov 19, 2014
 *      Author: rjiang
 */

#include "palindrome_number.h"
#include "gtest/gtest.h"

TEST(PalindromeNumber, One) {
    Solution obj;
    int x = 9898;
    bool expected = false;
    bool actual = obj.isPalindrome(x);
    EXPECT_EQ(expected, actual);
}

TEST(PalindromeNumber, Two) {
    Solution obj;
    int x = 9;
    bool expected = true;
    bool actual = obj.isPalindrome(x);
    EXPECT_EQ(expected, actual);
}
