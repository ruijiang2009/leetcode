package com.programapprentice.app;

/**
 * Created with IntelliJ IDEA.
 * User: ruijiang
 * Date: 8/14/14
 * Time: 7:42 PM
 */
public class RotateList {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /**
     * Given a list, rotate the list to the right by k places, where k is non-negative.
     * For example:
     * Given 1->2->3->4->5->NULL and k = 2,
     * return 4->5->1->2->3->NULL.
     * */

    public ListNode rotateRight(ListNode head, int n) {
        if(n == 0 || head == null) {
            return head;
        }
        ListNode k = head;
        for(int i = 0; i < n ; i++) {
            if(k == null) {
                k = head;
            }
            k = k.next;

        }

        ListNode p = head;
        while(k != null && k.next != null) {
            k = k.next;
            p = p.next;
        }
        if(k != null) {
            k.next = head;
            head = p.next;
            p.next = null;
        }
        return head;
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
