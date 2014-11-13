#ifndef REMOVE_DUPLICATES_FROM_SORTED_LIST_H
#define REMOVE_DUPLICATES_FROM_SORTED_LIST_H

#define NULL 0

struct ListNode {
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
};

class Solution {
public:
    ListNode *deleteDuplicates(ListNode *head);
};

#endif
