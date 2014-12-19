/*
 * linked_list_cycle.h
 *
 *  Created on: Dec 18, 2014
 *      Author: ruijiang
 */

#ifndef LINKED_LIST_CYCLE_H_
#define LINKED_LIST_CYCLE_H_

#define NULL 0

struct ListNode {
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
};

class Solution {
public:
    bool hasCycle(ListNode *head);
};

#endif /* LINKED_LIST_CYCLE_H_ */
