/*
 * reverse_integer_test.cc
 *
 *  Created on: Nov 7, 2014
 *      Author: ruijiang
 */
#include "reverse_integer.h"
#include "gtest/gtest.h"
#include <iostream>
#include <bitset>

using namespace::std;

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

TEST(ReverseInteger, Three) {
    Solution obj;
    int input = -443946297;
    int expected = -792649344;
    int actual = obj.reverse(input);
    cout<< "input    " << bitset<32>(input) << " decimal: " << input << endl;
    cout<< "expected " << bitset<32>(expected) << " decimal: " << expected << endl;
    EXPECT_EQ(expected, actual);
}

TEST(ReverseInteger, Four) {
    Solution obj;
    int input = 2147483643;
    int expected = -831119884;
    cout<< "input    " << bitset<32>(input) << endl;
    cout<< "expected " << bitset<32>(expected) << " decimal: " << expected << endl;
    int actual = obj.reverse(input);
    EXPECT_EQ(expected, actual);
}

TEST(ReverseInteger, Five) {
    Solution obj;
    int input = 2147483644;
    int expected = 168880116;
    cout<< "input    " << bitset<32>(input) << " decimal: " << input << endl;
    cout<< "expected " << bitset<32>(expected) << " decimal: " << expected << endl;
    int actual = obj.reverse(input);
    EXPECT_EQ(expected, actual);
}
