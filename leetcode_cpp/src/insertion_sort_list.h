/*
 * insertion_sort_list.h
 *
 *  Created on: Dec 17, 2014
 *      Author: ruijiang
 */

#ifndef INSERTION_SORT_LIST_H_
#define INSERTION_SORT_LIST_H_

// Sort a linked list using insertion sort.

#define NULL 0

struct ListNode {
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
};

class Solution {
public:
    ListNode *insertionSortList(ListNode *head);
};



#endif /* INSERTION_SORT_LIST_H_ */
