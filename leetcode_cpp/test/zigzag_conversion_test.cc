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
