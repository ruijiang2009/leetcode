#include "remove_duplicates_from_sorted_list.h"

ListNode* Solution::deleteDuplicates(ListNode *head) {
    if(NULL == head) {
        return head;
    }
    ListNode* p = head;
    ListNode* q = p->next;
    while(q != NULL) {
        if(q->val != p->val) {
            p->next = q;
            p = p->next;
        }
        q = q->next;
    }
    p->next = q;
    return head;
}
