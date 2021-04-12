package test.leetcode.linkedlist;

/**
 * @Author chenxiangge
 * @Date 3/26/21
 */
public class LC142 {
    public ListNode detectCycle(ListNode head) {
        //防止后面空指针
        if (head == null || head.next == null) {
            return null;
        }
        ListNode slow = head;
        //要区分 不然一开始就相等了 无法进入while循环
        ListNode fast = head.next;

        while (fast != slow) {
            if (fast == null || fast.next == null) {
                return null;
            }
            //如果不是环形节点 一定会循环到null
            slow = slow.next;
            fast = fast.next.next;
            //此时知道了当前是一个环形链表，并且快慢节点已经相遇
        }
        //题目的意思是要寻找入环点


        return fast;

    }
}
