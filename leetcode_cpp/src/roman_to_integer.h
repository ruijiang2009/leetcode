/*
 * roman_to_integer.h
 *
 *  Created on: Nov 18, 2014
 *      Author: ruijiang
 */

#ifndef ROMAN_TO_INTEGER_H_
#define ROMAN_TO_INTEGER_H_

#include <string>

using namespace::std;

/**
Given a roman numeral, convert it to an integer.
Input is guaranteed to be within the range from 1 to 3999.
*/

/**
Symbol  Value
I   1
V   5
X   10
L   50
C   100
D   500
M   1,000
*/
class Solution {
public:
    int romanToInt(string s);
    int dict(char c);
};


#endif /* ROMAN_TO_INTEGER_H_ */

