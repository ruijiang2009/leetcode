package com.programapprentice.app;

import org.junit.Test;

/**
 * @author rjiang
 * @date 7/31/14
 */
public class Test_SortList {
    SortList obj = new SortList();

    public void print(SortList.ListNode head) {
        SortList.ListNode p = head;
        while(p != null) {
            System.out.print(p.val + "\t");
            p = p.next;
        }
        System.out.println("");
    }

    @Test
    public void test1() {
        SortList.ListNode head = new SortList.ListNode(87);
        head.next = new SortList.ListNode(234);
        head.next.next = new SortList.ListNode(462);
        head.next.next.next = new SortList.ListNode(62);
        head = obj.sortList(head);
        print(head);
    }

}
