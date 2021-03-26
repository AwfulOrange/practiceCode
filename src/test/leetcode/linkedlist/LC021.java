package test.leetcode.linkedlist;

/**
 * @Author chenxiangge
 * @Date 3/26/21
 */
public class LC021 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode sentry = new ListNode(0);
        ListNode head = sentry;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                sentry.next = l1;
                sentry = sentry.next;
                l1 = l1.next;
            } else {
                sentry.next = l2;
                sentry = sentry.next;
                l2 = l2.next;
            }
        }
        if (l1 == null) {
            sentry.next = l2;
        } else {
            sentry.next = l1;
        }
        return head.next;
    }


}
