/*
 * add_binary_test.cc
 *
 *  Created on: Nov 14, 2014
 *      Author: ruijiang
 */

#include "add_binary.h"
#include "gtest/gtest.h"

TEST(AddBinary, One) {
    Solution obj;
    string a("10");
    string b("11");
    string expected("101");
    string actual = obj.addBinary(a, b);
    EXPECT_EQ(expected, actual);
}

TEST(AddBinary, Two) {
    Solution obj;
    string a("0");
    string b("0");
    string expected("0");
    string actual = obj.addBinary(a, b);
    EXPECT_EQ(expected, actual);
}

TEST(AddBinary, Three) {
    Solution obj;
    string a("0");
    string b("");
    string expected("0");
    string actual = obj.addBinary(a, b);
    EXPECT_EQ(expected, actual);
}
