package com.programapprentice.app;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * User: ruijiang
 * Date: 9/15/14
 * Time: 10:47 PM
 */
public class Test_MergeKSortedLists {
    MergeKSortedLists obj = new MergeKSortedLists();

    // [{1}, {0}]
    @Test
    public void test1() {
        MergeKSortedLists.ListNode head1 = new MergeKSortedLists.ListNode(1);
        MergeKSortedLists.ListNode head2 = new MergeKSortedLists.ListNode(0);
        List<MergeKSortedLists.ListNode> input = new ArrayList<MergeKSortedLists.ListNode>();
        input.add(head1);
        input.add(head2);

        obj.mergeKLists(input);
    }

    // [{1, 2, 2}, {1, 2, 2}]
    @Test
    public void test2() {
        MergeKSortedLists.ListNode head1 = new MergeKSortedLists.ListNode(1);
        head1.next = new MergeKSortedLists.ListNode(2);
        head1.next.next = new MergeKSortedLists.ListNode(2);

        MergeKSortedLists.ListNode head2 = new MergeKSortedLists.ListNode(1);
        head2.next = new MergeKSortedLists.ListNode(1);
        head2.next.next = new MergeKSortedLists.ListNode(2);

        List<MergeKSortedLists.ListNode> input = new ArrayList<MergeKSortedLists.ListNode>();
        input.add(head1);
        input.add(head2);

        obj.mergeKLists(input);
    }

    //[{2},{},{-1}]
    @Test
    public void test3() {
        MergeKSortedLists.ListNode head1 = new MergeKSortedLists.ListNode(2);

        MergeKSortedLists.ListNode head2 = null;

        MergeKSortedLists.ListNode head3 = new MergeKSortedLists.ListNode(-1);

        List<MergeKSortedLists.ListNode> input = new ArrayList<MergeKSortedLists.ListNode>();
        input.add(head1);
        input.add(head2);
        input.add(head3);

        obj.mergeKLists(input);
    }

}


