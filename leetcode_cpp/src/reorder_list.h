/*
 * reorder_list.h
 *
 *  Created on: Dec 17, 2014
 *      Author: ruijiang
 */

#ifndef REORDER_LIST_H_
#define REORDER_LIST_H_

/*
Given a singly linked list L: L0→L1→…→Ln-1→Ln,
reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

You must do this in-place without altering the nodes' values.

For example,
Given {1,2,3,4}, reorder it to {1,4,2,3}.
**/

#define NULL 0

struct ListNode {
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
};

class Solution {
public:
    void reorderList(ListNode *head);
};

#endif /* REORDER_LIST_H_ */
