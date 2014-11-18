/*
 * valid_parentheses.h
 *
 *  Created on: Nov 17, 2014
 *      Author: ruijiang
 */

#ifndef VALID_PARENTHESES_H_
#define VALID_PARENTHESES_H_

#include <string>

using namespace::std;

/**
 Given a string containing just the characters '(', ')', '{', '}',
 '[' and ']', determine if the input string is valid.

The brackets must close in the correct order, "()" and "()[]{}"
are all valid but "(]" and "([)]" are not.
*/

class Solution {
public:
    bool isValid(string s);
};
#endif /* VALID_PARENTHESES_H_ */
