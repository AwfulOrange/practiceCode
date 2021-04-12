package test.leetcode.aim;

import test.leetcode.linkedlist.ListNode;

/**
 * @Author chenxiangge
 * @Date 3/27/21
 */
public class Aim22 {
    public ListNode getKthFromEnd(ListNode head, int k) {
        int length = 0;
        ListNode cur = head;
        while (cur != null) {
            length++;
            cur = cur.next;
        }
        int startIndex = length - k;
        while (startIndex > 0) {
            head = head.next;
            startIndex--;
        }

        return head;

    }
}
