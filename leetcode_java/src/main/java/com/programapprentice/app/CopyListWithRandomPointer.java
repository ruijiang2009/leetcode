package com.programapprentice.app;

/**
 * User: ruijiang
 * Date: 8/1/14
 * Time: 5:44 PM
 */

import java.util.Random;

/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class CopyListWithRandomPointer {

    static class RandomListNode {
        int label;
        RandomListNode next, random;
        RandomListNode(int x) { this.label = x; }
    };

    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return null;
        }
        RandomListNode p = head;
        RandomListNode newHead = null;
        RandomListNode q = null;
        while(p != null) {
            if(newHead == null) {
                newHead = new RandomListNode(p.label);
                newHead.next = null;
                q = newHead;
            } else {
                q.next = new RandomListNode(p.label);
                q = q.next;
                q.next = null;
            }
            p = p.next;
        }

        // copy random list
        p = head;
        q = newHead;
        RandomListNode r1 = null;
        RandomListNode r2 = null;
        while(p != null) {
            r1 = head;
            r2 = newHead;
            if(p.random == null) {
                q.random = null;
            } else {
                while (r1 != p.random) {
                    r1 = r1.next;
                    r2 = r2.next;
                }
                q.random = r2;
            }
            q = q.next;
            p = p.next;
        }

        return newHead;
    }
}
