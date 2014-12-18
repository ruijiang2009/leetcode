/*
 * reorder_list_test.cc
 *
 *  Created on: Dec 17, 2014
 *      Author: ruijiang
 */


#include "reorder_list.h"
#include "gtest/gtest.h"

TEST(ReorderList, One) {
    Solution obj;
        ListNode * head = new ListNode(1);
        head->next = new ListNode(2);
        head->next->next = new ListNode(3);
        head->next->next->next = new ListNode(4);
        obj.reorderList(head);
        EXPECT_EQ(head->val, 1);
        EXPECT_EQ(head->next->val, 4);
        EXPECT_EQ(head->next->next->val, 2);
        EXPECT_EQ(head->next->next->next->val, 3);
}

TEST(ReorderList, Two) {
    Solution obj;
        ListNode * head = new ListNode(1);
        head->next = new ListNode(2);
        head->next->next = new ListNode(3);
        obj.reorderList(head);
        EXPECT_EQ(head->val, 1);
        EXPECT_EQ(head->next->val, 3);
        EXPECT_EQ(head->next->next->val, 2);
}

TEST(ReorderList, Three) {
    Solution obj;
        ListNode * head = new ListNode(1);
        head->next = new ListNode(2);
        head->next->next = new ListNode(3);
        head->next->next->next = new ListNode(4);
        head->next->next->next->next = new ListNode(5);
        head->next->next->next->next->next = new ListNode(6);
        head->next->next->next->next->next->next = new ListNode(7);
        obj.reorderList(head);
        EXPECT_EQ(head->val, 1);
        EXPECT_EQ(head->next->val, 7);
        EXPECT_EQ(head->next->next->val, 2);
        EXPECT_EQ(head->next->next->next->val, 6);
        EXPECT_EQ(head->next->next->next->next->val, 3);
        EXPECT_EQ(head->next->next->next->next->next->val, 5);
        EXPECT_EQ(head->next->next->next->next->next->next->val, 4);
}
