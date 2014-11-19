/*
 * longest_common_prefix_test.cc
 *
 *  Created on: Nov 18, 2014
 *      Author: ruijiang
 */

#include "longest_common_prefix.h"
#include "gtest/gtest.h"

TEST(LongestCommonPrefix, One) {
    Solution obj;
    vector<string> input;
    input.push_back("abc");
    input.push_back("abd");
    input.push_back("ad");
    string expected("a");
    string actual = obj.longestCommonPrefix(input);
    EXPECT_EQ(expected, actual);
}




