/*
 * insertion_sort_list.cc
 *
 *  Created on: Dec 17, 2014
 *      Author: ruijiang
 */

#include "insertion_sort_list.h"
#include <iostream>

using namespace::std;


// accepted
ListNode* Solution::insertionSortList(ListNode *head) {
    if(NULL == head || NULL == head->next) {
        return head;
    }

    ListNode * p, * q;
    ListNode * tmpHead = new ListNode(0);
    ListNode * newHead = head;
    head = head->next;
    newHead->next = NULL;
    tmpHead->next = newHead;
    while(head != NULL) {
        p = head;
        head = head->next;
        q = tmpHead;
        while(q->next != NULL && q->next->val < p->val) {
            q = q->next;
        }
        p->next = q->next;
        q->next = p;
    }
    newHead = tmpHead->next;
    return newHead;
}

/**
    ListNode *insertionSortList(ListNode *head) {
        if(NULL == head || NULL == head->next) {
            return head;
        }

        ListNode * p, * q, *r;
        ListNode * newHead = head;
        head = head->next;
        newHead->next = NULL;
        while(head != NULL) {
            p = head;
            head = head->next;
            p->next = NULL;
            q = newHead;
            while(q != NULL) {
                if(p->val <= q->val) {
                    p->next = q;
                    if(q == newHead) {
                        newHead = p;
                    } else {
                        r->next = p;
                    }
                    break;
                } else {
                    if(q->next == NULL) {
                        q->next = p;
                    } else {
                        r = q;
                        q = q->next;
                    }
                }
            }
        }
        return newHead;
    }
*/
