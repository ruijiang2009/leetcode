package com.programapprentice.app;

import java.util.List;

/**
 * User: ruijiang
 * Date: 9/15/14
 * Time: 9:56 PM
 */
public class MergeKSortedLists {
    public static class ListNode {
         int val;
         ListNode next;
         ListNode(int x) {
             val = x;
             next = null;
         }
    }

    public ListNode mergeKLists(List<ListNode> lists) {
        if(lists == null || lists.size() == 0) {
            return null;
        }
        if(lists.size() == 1) {
            return lists.get(0);
        }
        int k = lists.size();
        if(k == 0) {
            return null;
        }
        if(lists.get(0) == null) {
            return null;
        }
        ListNode[] heads = new ListNode[k];
        for(int i = 0; i < k; i++) {
            heads[i] = lists.get(i);
        }
        ListNode newHead = null;
        buildMinHeap(heads, k);
        newHead = heads[0];
        int headSize = k;
        ListNode tmp = null;
        tmp = newHead;
        if(tmp.next != null) {
            heads[0] = tmp.next;
        } else {
            headSize = k - 1;
        }
        int diff = k - headSize;

        while(headSize > 0) {
            heapify(heads, 1 + diff, headSize);
            tmp.next = heads[diff];
            tmp = tmp.next;
            if(tmp.next != null) {
                heads[diff] = tmp.next;
            } else {
                headSize--;
                diff = k - headSize;
            }
        }
        tmp.next = null;

        return newHead;
    }

    public void buildMinHeap(ListNode[] data, int length) {
        int heapSize = length;
        for(int i = heapSize / 2; i > 0; i--) {
            heapify(data, i, length);
        }
    }

    // index start with 1
    public void heapify(ListNode[] data, int index, int length) {

        int leftIndex = 2 * index;
        int rightIndex = 2 * index + 1;
        ListNode tmp = null;
        int minIndex = index;

        if(leftIndex <= length && data[leftIndex-1].val < data[index-1].val) {
            minIndex = leftIndex;
        }
        if(rightIndex <= length && data[rightIndex-1].val < data[minIndex-1].val) {
            minIndex = rightIndex;
        }

        if(minIndex != index) {
            tmp = data[minIndex-1];
            data[minIndex-1] = data[index-1];
            data[index-1] = tmp;
            heapify(data, minIndex, length);
        }

    }
}
