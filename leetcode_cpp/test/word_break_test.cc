/*
 * word_break_test.cc
 *
 *  Created on: Dec 20, 2014
 *      Author: ruijiang
 */

#include "word_break.h"
#include "gtest/gtest.h"

TEST(WordBreak, One) {
    Solution obj;
    string s("leetcode");
    unordered_set<string> dict;
    dict.insert("leet");
    dict.insert("code");
    bool expected = true;
    bool actual = obj.wordBreak(s, dict);
    EXPECT_EQ(expected, actual);
}

TEST(WordBreak, Two) {
    Solution obj;
    string s("leetcode");
    unordered_set<string> dict;
    dict.insert("lee");
    dict.insert("code");
    bool expected = false;
    bool actual = obj.wordBreak(s, dict);
    EXPECT_EQ(expected, actual);
}

