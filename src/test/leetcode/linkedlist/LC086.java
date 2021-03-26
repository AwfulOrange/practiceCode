package test.leetcode.linkedlist;

/**
 * @Author chenxiangge
 * @Date 3/26/21
 */
public class LC086 {
    public ListNode partition(ListNode head, int x) {
        //头节点-哨兵节点
        ListNode smaller = new ListNode(0);
        ListNode smallHead = smaller;
        ListNode bigger = new ListNode(0);
        ListNode biggerHead = bigger;
        while (head != null) {
            if (head.val < x) {
                smaller.next = head;
                smaller = smaller.next;
            } else {
                bigger.next = head;
                bigger = bigger.next;
            }
            head = head.next;
        }
        bigger.next = null;
        smaller.next = biggerHead.next;

        return smallHead.next;

    }
}
