/*
 * length_of_last_word_test.cc
 *
 *  Created on: Nov 16, 2014
 *      Author: ruijiang
 */

#include "length_of_last_word.h"
#include "gtest/gtest.h"
#include <string>

using namespace::std;

TEST(LengthOfLastWord, One) {
    Solution obj;
    string str = "Hello world";
    const char* s = str.c_str();
    int expected = 5;
    int actual = obj.lengthOfLastWord(s);
    EXPECT_EQ(expected, actual);
}

