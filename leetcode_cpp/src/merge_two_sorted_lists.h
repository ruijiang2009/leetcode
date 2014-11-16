/*
 * merge_two_sorted_lists.h
 *
 *  Created on: Nov 15, 2014
 *      Author: ruijiang
 */

#ifndef MERGE_TWO_SORTED_LISTS_H_
#define MERGE_TWO_SORTED_LISTS_H_

/***
Merge two sorted linked lists and return it as a new list.
The new list should be made by splicing together the nodes
of the first two lists.
*/
#define NULL 0
struct ListNode {
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
};

class Solution {
public:
    ListNode *mergeTwoLists(ListNode *l1, ListNode *l2);
};

#endif /* MERGE_TWO_SORTED_LISTS_H_ */
