package com.programapprentice.app;

/**
 * @author rjiang
 * @date 7/31/14
 */

/**
 * Sort a linked list in O(n log n) time using constant space complexity.
 * */
public class SortList {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode preSlow = head;
        ListNode fast = head;

        while(slow != null && fast != null) {
            if(slow != head) {
                preSlow = preSlow.next;
            }
            slow = slow.next;
            fast = fast.next;
            fast = fast == null ? null : fast.next;
        }
        preSlow.next = null;
        fast = slow;
        slow = head;
        fast = sortList(fast);
        slow = sortList(slow);
        return mergeList(slow, fast);
    }

    public ListNode mergeList(ListNode one, ListNode two) {
        ListNode head = new ListNode(0);
        ListNode a = one;
        ListNode b = two;
        ListNode p = head;

        while(a != null && b != null) {
            if(a.val < b.val) {
                p.next = a;
                a = a.next;
            } else if( a.val > b.val) {
                p.next = b;
                b = b.next;
            } else {
                p.next = a;
                a = a.next;
                p = p.next;
                p.next = b;
                b = b.next;
            }
            p = p.next;
            p.next = null;
        }

        p.next = a == null ? b : a;
        return head.next;
    }
}
