package com.programapprentice.app;

/**
 * User: ruijiang
 * Date: 12/8/14
 * Time: 1:49 PM
 */
/**
 Write a program to find the node at which the intersection of two singly linked lists begins.


 For example, the following two linked lists:

 A:          a1 → a2
 ↘
 c1 → c2 → c3
 ↗
 B:     b1 → b2 → b3
 begin to intersect at node c1.


 Notes:

 If the two linked lists have no intersection at all, return null.
 The linked lists must retain their original structure after the function returns.
 You may assume there are no cycles anywhere in the entire linked structure.
 Your code should preferably run in O(n) time and use only O(1) memory.
 * */
public class IntersectionOfTwoLinkedLists {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lengthA = 0;
        int lengthB = 0;
        ListNode p = headA;
        while(p != null) {
            lengthA++;
            p = p.next;
        }

        p = headB;
        while(p != null) {
            lengthB++;
            p = p.next;
        }
        ListNode pA = headA;
        ListNode pB = headB;
        if(lengthA > lengthB) {
            for(int i = 0; i < lengthA-lengthB; i++) {
                pA = pA.next;
            }
        } else if (lengthA < lengthB) {
            for(int i = 0; i < lengthB-lengthA; i++) {
                pB = pB.next;
            }
        }
        while(pA != null && pB != null) {
            if(pA == pB || pA.val == pB.val) {
                break;
            }
            pA = pA.next;
            pB = pB.next;
        }
        return pA;
    }
}
