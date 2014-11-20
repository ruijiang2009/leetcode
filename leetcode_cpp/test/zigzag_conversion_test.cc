/*
 * zigzag_conversion_test.cc
 *
 *  Created on: Nov 19, 2014
 *      Author: rjiang
 */

#include "zigzag_conversion.h"
#include "gtest/gtest.h"

TEST(ZigzagConversion, One) {
    Solution obj;
    string s("PAYPALISHIRING");
    int nRows = 3;
    string expected = "PAHNAPLSIIGYIR";
    string actual = obj.convert(s, nRows);
    EXPECT_EQ(expected, actual);
}

TEST(ZigzagConversion, Two) {
    Solution obj;
    string s("0123456789");
    int nRows = 4;
    string expected = "0615724839";
    string actual = obj.convert(s, nRows);
    EXPECT_EQ(expected, actual);
}

TEST(ZigzagConversion, Three) {
    Solution obj;
    string s;
    int nRows = 2;
    string expected = "";
    string actual = obj.convert(s, nRows);
    EXPECT_EQ(expected, actual);
}

TEST(ZigzagConversion, Four) {
    Solution obj;
    string s("0123456789");
    int nRows = 2;
    string expected = "0246813579";
    string actual = obj.convert(s, nRows);
    EXPECT_EQ(expected, actual);
}

TEST(ZigzagConversion, Five) {
    Solution obj;
    string s("");
    int nRows = 2;
    string expected = "";
    string actual = obj.convert(s, nRows);
    EXPECT_EQ(expected, actual);
}
