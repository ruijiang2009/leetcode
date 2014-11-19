/*
 * zigzag_conversion.h
 *
 *  Created on: Nov 19, 2014
 *      Author: rjiang
 */

#ifndef ZIGZAG_CONVERSION_H_
#define ZIGZAG_CONVERSION_H_

#include <string>

using namespace::std;

/**
The string "PAYPALISHIRING" is written in a zigzag pattern on a given
number of rows like this: (you may want to display this pattern in a
fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"
Write the code that will take a string and make this conversion given
a number of rows:

string convert(string text, int nRows);
convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
*/

class Solution {
public:
    string convert(string s, int nRows);
};
#endif /* ZIGZAG_CONVERSION_H_ */
