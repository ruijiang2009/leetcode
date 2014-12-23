/*
 * word_break.h
 *
 *  Created on: Dec 20, 2014
 *      Author: ruijiang
 */

#ifndef WORD_BREAK_H_
#define WORD_BREAK_H_

#include <string>
#include <unordered_set>

using namespace::std;


/**
Given a string s and a dictionary of words dict, determine if s can be
segmented into a space-separated sequence of one or more dictionary words.

For example, given
s = "leetcode",
dict = ["leet", "code"].

Return true because "leetcode" can be segmented as "leet code".
 * */
class Solution {
public:
    bool wordBreak(string s, unordered_set<string> &dict);
};

#endif /* WORD_BREAK_H_ */
