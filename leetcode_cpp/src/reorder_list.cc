/*
 * reorder_list.cc
 *
 *  Created on: Dec 17, 2014
 *      Author: ruijiang
 */

#include "reorder_list.h"
#include <iostream>

using namespace::std;

// time complexity:
void Solution::reorderList(ListNode *head) {
    if(NULL == head || NULL == head->next) {
        return;
    }
    int length = 0;
    ListNode * p = head;
    while(p != NULL) {
        p = p->next;
        length++;
    }
    int halfLength = length / 2 + (length % 2);
    p = head;
    for(int i = 0; i < halfLength - 1; i++) {
        p = p->next;
    }
    cout << "p->val " << p->val << endl;

    // reverse otherHead
    ListNode * otherHead = p->next;
    p->next = NULL;
    ListNode * q = otherHead->next;
    ListNode * r = otherHead;
    otherHead->next = NULL;
    while(q != NULL) {
        r = q->next;
        q->next = otherHead;
        otherHead = q;
        q = r;
    }

    // merge two lists
    halfLength = length / 2;
    p = head;
    q = otherHead;
    r = p;
    ListNode *s = q;
    for(int i = 0; i < halfLength; i++) {
        if(r == NULL) {
            cout << "r is NULL \n";
        }
        if(s == NULL) {
            cout << "s is NULL \n";
        }
        s = s->next;
        r = r->next;
        q->next = p->next;
        p->next = q;
        p = r;
        q = s;
    }
}
