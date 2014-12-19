/*
 * linked_list_cycle.cc
 *
 *  Created on: Dec 18, 2014
 *      Author: ruijiang
 */

#include "linked_list_cycle.h"

bool Solution::hasCycle(ListNode *head) {
    ListNode *p = head;
    ListNode *q = head;
    while(p != NULL && q != NULL) {
        p = p->next;
        q = q->next;
        if(q != NULL) {
            q = q->next;
        } else {
            return false;
        }
        if(p == q) {
            return true;
        }
    }
    return false;
}
