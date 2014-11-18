/*
 * remove_nth_node_from_end_of_list.h
 *
 *  Created on: Nov 17, 2014
 *      Author: ruijiang
 */

#ifndef REMOVE_NTH_NODE_FROM_END_OF_LIST_H_
#define REMOVE_NTH_NODE_FROM_END_OF_LIST_H_


/**
Given a linked list, remove the nth node from the end of list and
return its head.
For example,
   Given linked list: 1->2->3->4->5, and n = 2.
   After removing the second node from the end, the linked list
   becomes 1->2->3->5.
*/

#define NULL 0

struct ListNode {
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
};

class Solution {
public:
    ListNode *removeNthFromEnd(ListNode *head, int n);
};

#endif /* REMOVE_NTH_NODE_FROM_END_OF_LIST_H_ */
