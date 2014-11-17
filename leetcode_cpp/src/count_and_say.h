/*
 * count_and_say.h
 *
 *  Created on: Nov 16, 2014
 *      Author: ruijiang
 */

#ifndef COUNT_AND_SAY_H_
#define COUNT_AND_SAY_H_

#include <string>

using namespace::std;

/**
The count-and-say sequence is the sequence of integers beginning as follows:
1, 11, 21, 1211, 111221, ...

1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.
Given an integer n, generate the nth sequence.

Note: The sequence of integers will be represented as a string.
*/

class Solution {
public:
    string countAndSay(int n);
};


#endif /* COUNT_AND_SAY_H_ */
