package com.programapprentice.app;

/**
 * Created with IntelliJ IDEA.
 * User: ruijiang
 * Date: 1/9/15
 * Time: 7:25 PM
 */
public class PartitionList {
    public static class ListNode {
         int val;
         ListNode next;
         ListNode(int x) {
             val = x;
             next = null;
         }
    }
    public ListNode partition(ListNode head, int x) {
        ListNode lessHead = null;
        ListNode lessTail = null;

        ListNode p = head;
        ListNode q = p;
        ListNode pre = null;
        while(p != null) {
            q = p.next;
            if(p.val < x) {
                // insert this node to less list
                if(lessHead == null) {
                    lessHead = p;
                    lessTail = p;
                } else {
                    lessTail.next = p;
                    lessTail = lessTail.next;
                }
                if(head == p) {
                    head = q;
                }
                if(pre != null) {
                    pre.next = q;
                }
            } else {
                pre = p;
            }
            p = q;
        }
        if(null != lessHead) {
            lessTail.next = head;
            return lessHead;
        }
        return head;
    }
}