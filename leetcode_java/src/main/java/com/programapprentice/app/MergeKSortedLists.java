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
        ListNode[] heads = new ListNode[k];
        int headSize = 0;
        for(int i = 0; i < k; i++) {
            if(lists.get(i) == null)
                continue;
            heads[headSize] = lists.get(i);
            headSize++;
        }
        if(0 == headSize) {
            return null;
        }
        ListNode newHead = null;
        buildMinHeap(heads, headSize);
        newHead = heads[0];

        ListNode tmp = null;
        tmp = newHead;
        if(tmp.next != null) {
            heads[0] = tmp.next;
        } else {
            // move the last one to the current
            heads[0] = heads[headSize-1];
            headSize--;
        }

        while(headSize > 0) {
            heapify(heads, 1, headSize);
            tmp.next = heads[0];
            tmp = tmp.next;
            if(tmp.next != null) {
                heads[0] = tmp.next;
            } else {
                if(headSize >= 1) {
                    heads[0] = heads[headSize - 1];
                    headSize--;
                } else {
                    break;
                }
            }
        }
        tmp.next = null;

        return newHead;
    }

    public void buildMinHeap(ListNode[] data, int length) {
        if(0 == length) {
            return;
        }
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
