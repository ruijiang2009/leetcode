/*
 * remove_nth_node_from_end_of_list.cc
 *
 *  Created on: Nov 17, 2014
 *      Author: ruijiang
 */

#include "remove_nth_node_from_end_of_list.h"
#include <iostream>

using namespace::std;


ListNode *Solution::removeNthFromEnd(ListNode *head, int n) {
    if(NULL == head) {
        return head;
    }
    ListNode *p = head;
    ListNode *q = head;
    int i = 0;

    while(i < n && p != NULL) {
        p = p->next;
        i++;
    }

    if(p == NULL) {
        head = head->next;
        q->next = NULL;
        return head;
    }

    while(p != NULL && p->next != NULL) {
        p = p->next;
        q = q->next;
    }

    p = q->next;
    q->next = q->next->next;
    p->next = NULL;

    return head;
}


