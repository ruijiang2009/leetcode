package com.programapprentice.app;

import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: ruijiang
 * Date: 7/23/14
 * Time: 10:20 PM
 */
public class Test_ReorderList {

    @Test
    public void test1() {
        ReorderList.ListNode head = new ReorderList.ListNode(0);
        head.next = new ReorderList.ListNode(1);
        head.next.next = new ReorderList.ListNode(2);

        ReorderList.reorderList(head);
        ReorderList.printList(head);
    }

    @Test
    public void test2() {
        ReorderList.ListNode head = new ReorderList.ListNode(0);
        head.next = new ReorderList.ListNode(1);
        head.next.next = new ReorderList.ListNode(2);
        head.next.next.next = new ReorderList.ListNode(3);

        ReorderList.reorderList(head);
        ReorderList.printList(head);
    }
}
