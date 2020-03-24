package com.anyu.leetcode.link;

/**
 * 合并多个有序链表
 */
public class MergeKLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length < 1)
            return null;
//        方法一：
        ListNode res = new ListNode(-1);
        for (ListNode node : lists) {
            res = merge(res.next, node);
        }
        return res.next;
//        //方法二
//        return cutLists(lists,0,lists.length-1);
    }

    public ListNode cutLists(ListNode[] lists, int left, int right) {
        if (left == right)
            return lists[left];
        else if (right - left > 1) {
            int mid = (left + right) / 2;
            ListNode L = cutLists(lists, left, mid);
            ListNode R = cutLists(lists, mid - 1, right);
            return merge(L, R);
        } else if (right - left == 1)
            return merge(lists[left], lists[right]);
        else
            return null;
    }

    public ListNode merge(ListNode left, ListNode right) {
        if (left == null)
            return right;
        if (right == null)
            return left;
        if (left.val > right.val) {
            right.next = merge(left, right.next);
            return right;
        } else {
            left.next = merge(left.next, right);
            return left;
        }
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
