/*
 * remove_nth_node_from_end_of_list_test.cc
 *
 *  Created on: Nov 18, 2014
 *      Author: ruijiang
 */


#include "remove_nth_node_from_end_of_list.h"
#include "gtest/gtest.h"

TEST(RemoveNthNodeFromEndofLine, One) {
    Solution obj;
    ListNode *head = new ListNode(1);
    ListNode *expect = NULL;
    ListNode *actual = obj.removeNthFromEnd(head, 1);
    EXPECT_EQ(expect, actual);
}

TEST(RemoveNthNodeFromEndofLine, Two) {
    Solution obj;
    ListNode *head = new ListNode(1);
    head->next = new ListNode(2);
    ListNode *expect = head;
    ListNode *actual = obj.removeNthFromEnd(head, 1);
    EXPECT_EQ(expect, actual);
}

TEST(RemoveNthNodeFromEndofLine, Three) {
    Solution obj;
    ListNode *head = new ListNode(1);
    head->next = new ListNode(2);
    ListNode *expect = head->next;
    ListNode *actual = obj.removeNthFromEnd(head, 2);
    EXPECT_EQ(expect, actual);
}
