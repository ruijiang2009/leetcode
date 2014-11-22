/*
 * find_minimum_in_rotated_sorted_array.h
 *
 *  Created on: Nov 22, 2014
 *      Author: ruijiang
 */

#ifndef FIND_MINIMUM_IN_ROTATED_SORTED_ARRAY_H_
#define FIND_MINIMUM_IN_ROTATED_SORTED_ARRAY_H_

#include <vector>

using namespace::std;

/**
Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

Find the minimum element.

You may assume no duplicate exists in the array.
*/

class Solution {
public:
    int findMin(vector<int> &num);
};

#endif /* FIND_MINIMUM_IN_ROTATED_SORTED_ARRAY_H_ */
