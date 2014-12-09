package com.programapprentice.app;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * User: ruijiang
 * Date: 12/8/14
 * Time: 10:56 PM
 */
public class Test_IntersectionOfTwoLinkedLists {
    IntersectionOfTwoLinkedLists obj = new IntersectionOfTwoLinkedLists();

    @Test
    public void test1() {
        IntersectionOfTwoLinkedLists.ListNode headA = new IntersectionOfTwoLinkedLists.ListNode(1);
        IntersectionOfTwoLinkedLists.ListNode headB = null;
        IntersectionOfTwoLinkedLists.ListNode expected = null;
        IntersectionOfTwoLinkedLists.ListNode actual = obj.getIntersectionNode(headA, headB);
        assertEquals(expected, actual);
    }

    @Test
    public void test2() {
        IntersectionOfTwoLinkedLists.ListNode headA = null;
        IntersectionOfTwoLinkedLists.ListNode headB = null;
        IntersectionOfTwoLinkedLists.ListNode expected = null;
        IntersectionOfTwoLinkedLists.ListNode actual = obj.getIntersectionNode(headA, headB);
        assertEquals(expected, actual);
    }
}
