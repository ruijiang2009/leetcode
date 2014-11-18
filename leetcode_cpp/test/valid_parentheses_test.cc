/*
 * valid_parentheses_test.cc
 *
 *  Created on: Nov 17, 2014
 *      Author: ruijiang
 */

#include "valid_parentheses.h"
#include "gtest/gtest.h"

TEST(ValidParentheses, One) {
    Solution obj;
    string s("()[]{}");
    bool expected = true;
    bool actual = obj.isValid(s);
    EXPECT_EQ(expected, actual);
}

TEST(ValidParentheses, Two) {
    Solution obj;
    string s("}()[]{}");
    bool expected = false;
    bool actual = obj.isValid(s);
    EXPECT_EQ(expected, actual);
}

TEST(ValidParentheses, Three) {
    Solution obj;
    string s("}");
    bool expected = false;
    bool actual = obj.isValid(s);
    EXPECT_EQ(expected, actual);
}
