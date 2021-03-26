package test.leetcode.linkedlist;

/**
 * @Author chenxiangge
 * @Date 3/26/21
 */
public class LC083 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode sentry = head;
        while (sentry != null && sentry.next != null) {
            if(sentry.val == sentry.next.val){
                sentry.next = sentry.next.next;
            }else{
                sentry = sentry.next;
            }
        }

        return head;

    }
}
