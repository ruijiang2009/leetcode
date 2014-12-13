/*
 * intersection_of_two_linked_lists.cc
 *
 *  Created on: Dec 8, 2014
 *      Author: ruijiang
 */

/**
Write a program to find the node at which the intersection of two singly linked lists begins.


For example, the following two linked lists:

A:          a1 → a2
                   ↘
                     c1 → c2 → c3
                   ↗
B:     b1 → b2 → b3
begin to intersect at node c1.


Notes:

If the two linked lists have no intersection at all, return null.
The linked lists must retain their original structure after the function returns.
You may assume there are no cycles anywhere in the entire linked structure.
Your code should preferably run in O(n) time and use only O(1) memory.
*/

#include "intersection_of_two_linked_lists.h"


ListNode * Solution::getIntersectionNode(ListNode *headA, ListNode *headB) {
    ListNode* pA = headA;
    ListNode* pB = headB;

    while(pA != pB) {
        if(pA == NULL) {
            pA = headB;
        } else {
            pA = pA->next;
        }
        if(pB == NULL) {
            pB = headA;
        } else {
            pB = pB->next;
        }
    }
    return pA;
}

