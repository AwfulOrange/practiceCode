package test.leetcode.linkedlist;

/**
 * @Author chenxiangge
 * @Date 3/26/21
 */
public class LC141 {
    public boolean hasCycle(ListNode head) {
        //防止后面空指针
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        //要区分 不然一开始就相等了 无法进入while循环
        ListNode fast = head.next;

        while (fast != slow) {
            if (fast == null || fast.next == null) {
                return false;
            }
            //如果不是环形节点 一定会循环到null
            slow = slow.next;
            fast = fast.next.next;

        }
        return true;

    }
}
