/*
 * pascal_triangle_ii.h
 *
 *  Created on: Nov 8, 2014
 *      Author: ruijiang
 */

#ifndef PASCAL_TRIANGLE_II_H_
#define PASCAL_TRIANGLE_II_H_

#include <vector>

using namespace::std;

/**
 * Given an index k, return the kth row of the Pascal's triangle.
 * For example, given k = 3,
 * Return [1,3,3,1].
 * Note:
 * Could you optimize your algorithm to use only O(k) extra space?*/

class Solution {
public:
    vector<int> getRow(int rowIndex);
};

#endif /* PASCAL_TRIANGLE_II_H_ */
