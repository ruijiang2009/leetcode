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

    public static void reorderList(ListNode head) {
        if(head == null || head.next == null || head.next.next == null) {
            return;
        }
        ListNode evenList = null;
        ListNode pEven = null;
        ListNode oddList = null;
        ListNode pOdd = null;
        ListNode p = head;
        while(p != null) {
            if(evenList == null) {
                evenList = p;
                pEven = evenList;
                p = p.next;
                pEven.next = null;
                if(p == null) {
                    break;
                } else {
                    oddList = p;
                    pOdd = oddList;
                    p = p.next;
                    pOdd.next = null;
                }
            } else {
                pEven.next = p;
                p = p.next;
                pEven = pEven.next;
                pEven.next = null;
                if(p == null) {
                    break;
                } else {
                    pOdd = p;
                    p = p.next;
                    pOdd.next = oddList;
                    oddList = pOdd;
                }
            }
        }
        printList(evenList);
        printList(oddList);
        pEven = evenList;
        pOdd = oddList;
        head = evenList;
        ListNode qEven = null;
        ListNode qOdd = null;
        while(pOdd != null) {
            qOdd = pOdd.next;
            qEven = pEven.next;
            pOdd.next = pEven.next;
            pEven.next = pOdd;
            pOdd = qOdd;
            pEven = qEven;
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
