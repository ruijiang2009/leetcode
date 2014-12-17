/*
 * insertion_sort_list_test.cc
 *
 *  Created on: Dec 17, 2014
 *      Author: ruijiang
 */

#include "gtest/gtest.h"
#include "insertion_sort_list.h"
#include <iostream>

using namespace::std;

//TEST(InsertionSortList, One) {
//    Solution obj;
//    ListNode * head = new ListNode(1);
//    head->next = new ListNode(1);
//    ListNode * newHead = obj.insertionSortList(head);
//    EXPECT_EQ(newHead->val, 1);
//    EXPECT_EQ(newHead->next->val, 1);
//}

TEST(InsertionSortList, Two) {
    Solution obj;
    ListNode * head = new ListNode(3);
    head->next = new ListNode(2);
    head->next->next = new ListNode(4);
    ListNode * newHead = obj.insertionSortList(head);
    EXPECT_EQ(newHead->val, 2);
    cout << "new head" << newHead->val << endl;
    EXPECT_EQ(newHead->next->val, 3);
    cout << "new head" << newHead->next->val << endl;
    EXPECT_EQ(newHead->next->next->val, 4);
    cout << "new head" << newHead->next->next->val << endl;
}
