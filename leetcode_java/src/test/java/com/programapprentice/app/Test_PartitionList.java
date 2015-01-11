package com.programapprentice.app;

import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: ruijiang
 * Date: 1/9/15
 * Time: 7:26 PM
 */
public class Test_PartitionList {

    @Test
    public void test1() {
        PartitionList obj = new PartitionList();

        PartitionList.ListNode head = new PartitionList.ListNode(2);
        head.next = new PartitionList.ListNode(1);

        PartitionList.ListNode preHead = obj.partition(head, 2);
    }
}
