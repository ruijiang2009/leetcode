/*
 * remove_duplicates_from_sorted_array.h
 *
 *  Created on: Nov 17, 2014
 *      Author: ruijiang
 */

#ifndef REMOVE_DUPLICATES_FROM_SORTED_ARRAY_H_
#define REMOVE_DUPLICATES_FROM_SORTED_ARRAY_H_


/**
Given a sorted array, remove the duplicates in place such that each element
appear only once and return the new length.

Do not allocate extra space for another array, you must do this in place with
constant memory.

For example,
Given input array A = [1,1,2],

Your function should return length = 2, and A is now [1,2].
*/

class Solution {
public:
    int removeDuplicates(int A[], int n);
};
#endif /* REMOVE_DUPLICATES_FROM_SORTED_ARRAY_H_ */
