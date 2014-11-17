/*
 * count_and_say_test.cc
 *
 *  Created on: Nov 16, 2014
 *      Author: ruijiang
 */

#include "count_and_say.h"
#include "gtest/gtest.h"

TEST(CountAndSay, One) {
    Solution obj;
    string expected("21");
    string actual = obj.countAndSay(3);
    EXPECT_EQ(expected, actual);
}

TEST(CountAndSay, Two) {
    Solution obj;
    string expected("1211");
    string actual = obj.countAndSay(4);
    EXPECT_EQ(expected, actual);
}

TEST(CountAndSay, Three) {
    Solution obj;
    string expected("111221");
    string actual = obj.countAndSay(5);
    EXPECT_EQ(expected, actual);
}
