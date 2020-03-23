package com.anyu.leetcode.link;

/**
 * 给定一个带有头结点 head 的非空单链表，返回链表的中间结点。
 * 如果有两个中间结点，则返回第二个中间结点。
 */
public class MiddleNode {
    public ListNode middleNode(ListNode head) {
        ListNode curL = head;
        ListNode curR = head;
        while (curR.next != null && curR.next.next != null) {
            curL = curL.next;
            curR = curR.next.next;
        }
        if (curR.next == null)
            return curL;
        else
            return curL.next;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}