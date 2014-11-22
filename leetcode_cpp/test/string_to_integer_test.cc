/*
 * string_to_integer_test.cc
 *
 *  Created on: Nov 21, 2014
 *      Author: ruijiang
 */

#include "string_to_integer.h"
#include "gtest/gtest.h"
#include <string>

using namespace::std;

TEST(StringToInteger, One) {
    Solution obj;
    string s("12345");
    int expected = 12345;
    int actual = obj.atoi(s.c_str());
    EXPECT_EQ(expected, actual);
}

TEST(StringToInteger, Two) {
    Solution obj;
    string s(" -0012a42 ");
    int expected = -12;
    int actual = obj.atoi(s.c_str());
    EXPECT_EQ(expected, actual);
}

TEST(StringToInteger, Three) {
    Solution obj;
    string s(" -12345 ");
    int expected = -12345;
    int actual = obj.atoi(s.c_str());
    EXPECT_EQ(expected, actual);
}

TEST(StringToInteger, Four) {
    Solution obj;
    string s("-+12345");
    int expected = 0;
    int actual = obj.atoi(s.c_str());
    EXPECT_EQ(expected, actual);
}

TEST(StringToInteger, Five) {
    Solution obj;
    string s("2147483648");
    int expected = 2147483647;
    int actual = obj.atoi(s.c_str());

    EXPECT_EQ(expected, actual);
}

TEST(StringToInteger, Six) {
    Solution obj;
    string s("-2147483649");
    int expected = -2147483648;
    int actual = obj.atoi(s.c_str());
    EXPECT_EQ(expected, actual);
}

TEST(StringToInteger, Seven) {
    Solution obj;
    string s("      -11919730356x");
    int expected = -2147483648;
    int actual = obj.atoi(s.c_str());
    cout << "actual " << actual << endl;
    EXPECT_EQ(expected, actual);
}
