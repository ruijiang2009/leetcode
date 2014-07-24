package com.programapprentice.app;

/**
 * Created with IntelliJ IDEA.
 * User: ruijiang
 * Date: 7/23/14
 * Time: 10:02 PM
 */

/**
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
 * reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
 *
 * You must do this in-place without altering the nodes' values.
 *
 * For example,
 * Given {1,2,3,4}, reorder it to {1,4,2,3}.
 */

public class ReorderList {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /**
     * space complexity: O(1)
     * time complexity: O(n^2)
     * */
    public static void reorderListSlow(ListNode head) {
        if(head == null || head.next == null || head.next.next == null) {
            return;
        }
        ListNode p = head;
        ListNode cur = null;
        ListNode pre = null;
        while(p.next != null && p.next.next != null) {
            pre = p;
            cur = pre.next;
            while(cur.next != null) {
                cur = cur.next;
                pre = pre.next;
            }
            pre.next = null;
            cur.next = p.next;
            p.next = cur;
            p = cur.next;
        }
    }

    /**
     * space complexity: O(1)
     * time complexity: O(n)
     * */
    public static void reorderList(ListNode head) {
        if(head == null || head.next == null || head.next.next == null) {
            return;
        }
        // 1. find the length of list
        int length = 0;
        ListNode p = head;
        while(p != null) {
            length ++;
            p = p.next;
        }
        boolean isOdd = (length % 2) == 1;

        // 2. reverse the latter half list
        int halfLength = isOdd ? length / 2 : (length / 2 - 1);

        p = head;
        for(int i = 0; i < halfLength; i++) {
            p = p.next;
        }
        ListNode latterHalf = p.next;
        p.next = null;

        p = latterHalf.next;
        latterHalf.next = null;
        ListNode q = null;
        while(p != null) {
            q = p.next;
            p.next = latterHalf;
            latterHalf = p;
            p = q;
        }

        // 3. start merge two lists
        p = head;
        q = latterHalf;
        while(latterHalf != null) {
            latterHalf = q.next;
            q.next = p.next;
            p.next = q;
            p = q.next;
            q = latterHalf;
        }
    }

    public static void printList(ListNode head) {
        ListNode p = head;
        while(p != null) {
            System.out.print(p.val + "\t");
            p = p.next;
        }
        System.out.println();
    }
}
