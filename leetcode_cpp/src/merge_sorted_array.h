/*
 * merge_sorted_array.h
 *
 *  Created on: Nov 12, 2014
 *      Author: ruijiang
 */

#ifndef MERGE_SORTED_ARRAY_H_
#define MERGE_SORTED_ARRAY_H_

/**
Given two sorted integer arrays A and B, merge B into A as one sorted array.

Note:
You may assume that A has enough space (size that is greater or equal to m + n)
to hold additional elements from B. The number of elements initialized in A and
B are m and n respectively.*/

class Solution {
public:
    void merge(int A[], int m, int B[], int n);
};



#endif /* MERGE_SORTED_ARRAY_H_ */
