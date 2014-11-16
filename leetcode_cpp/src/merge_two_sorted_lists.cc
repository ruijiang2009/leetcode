/*
 * merge_two_sorted_lists.cc
 *
 *  Created on: Nov 15, 2014
 *      Author: ruijiang
 */

#include "merge_two_sorted_lists.h"

ListNode* Solution::mergeTwoLists(ListNode *l1, ListNode *l2) {
    if(l2 == NULL) {
        return l1;
    }
    if(l1 == NULL) {
        return l2;
    }
    ListNode *p1 = l1;
    ListNode *p2 = l2;
    ListNode *newHead = NULL;
    if(p1->val < p2->val) {
        newHead = p1;
        p1 = p1->next;
    } else {
        newHead = p2;
        p2 = p2->next;
    }
    ListNode *p = newHead;
    while(p1 != NULL && p2 != NULL) {
        if(p1->val < p2->val) {
            p->next = p1;
            p1 = p1->next;
        } else {
            p->next = p2;
            p2 = p2->next;
        }
        p = p->next;
    }

    if(p1 == NULL) {
        p->next = p2;
    } else {
        p->next = p1;
    }

    return newHead;
}
