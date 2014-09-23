package com.programapprentice.app;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * User: ruijiang
 * Date: 9/15/14
 * Time: 9:56 PM
 */

/**
 *
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 * One solution:
 * http://blog.csdn.net/linhuanmars/article/details/19899259
 * */
public class MergeKSortedLists {
    public static class ListNode {
         int val;
         ListNode next;
         ListNode(int x) {
             val = x;
             next = null;
         }
    }

    // my own heap method is too slow
    public ListNode mergeKListsV1(List<ListNode> lists) {
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

    // using priority queue
    public ListNode mergeKListsV2(List<ListNode> lists) {
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<ListNode>(10, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode listNode, ListNode listNode2) {
                return listNode.val - listNode2.val;
            }
        });

        for(int i = 0; i < lists.size(); i++)
        {
            ListNode node = lists.get(i);
            if(node!=null)
            {
                priorityQueue.offer(node);
            }
        }
        ListNode head = null;
        ListNode pre = head;
        while(priorityQueue.size()>0)
        {
            ListNode cur = priorityQueue.poll();
            if(head == null) {
                head = cur;
                pre = head;
            } else {
                pre.next = cur;
            }
            pre = cur;
            if(cur.next!=null) {
                priorityQueue.offer(cur.next);
            }
        }
        return head;
    }

    public ListNode mergeKLists(List<ListNode> lists) {
        if(lists == null || lists.size() == 0) {
            return null;
        }
        if(lists.size() == 1) {
            return lists.get(0);
        }


        return mergeLists(lists, 0, lists.size() - 1);

    }

    public ListNode mergeLists(List<ListNode> lists, int start, int end) {
        if(start == end) {
            return lists.get(start);
        }
        if(end - 1 == start) {
            return merge2Lists(lists.get(start), lists.get(end));
        } else {
            return merge2Lists(mergeLists(lists, start, start + (end-start)/2),
                               mergeLists(lists, start + (end-start)/2 + 1, end));
        }

    }

    public ListNode merge2Lists(ListNode h1, ListNode h2) {
        if(h1 == null && h2 == null) {
            return null;
        } else if (h1 == null) {
            return h2;
        } else if (h2 == null) {
            return h1;
        }
        ListNode p1 = h1;
        ListNode p2 = h2;
        ListNode newHead = null;
        if(p1.val > p2.val) {
            newHead = p2;
            p2 = p2.next;
        } else {
            newHead = p1;
            p1 = p1.next;
        }
        ListNode p = newHead;
        while(p1 != null && p2 != null) {
            if(p1.val > p2.val) {
                p.next = p2;
                p2 = p2.next;
            } else {
                p.next = p1;
                p1 = p1.next;
            }
            p = p.next;
        }
        if(p1 == null) {
            p.next = p2;
        } else {
            p.next = p1;
        }
        return newHead;
    }

}
