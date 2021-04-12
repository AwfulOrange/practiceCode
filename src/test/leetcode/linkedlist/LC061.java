package test.leetcode.linkedlist;

/**
 * @Author chenxiangge
 * @Date 3/27/21
 */
public class LC061 {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) {
            return head;
        }
        int length = 1;
        ListNode breakPoint = head;
        //新开始
        ListNode newHead = new ListNode(0);
        ListNode end = head;
        //计算长度并拿到尾指针
        while (end.next != null) {
            length++;
            end = end.next;
        }
        if (k % length == 0) {
            return head;
        }

        //获得链表长度，根据k计算链表断开点
        int breakPointIndex = length - (k % length);
        int breakStart = 1;
        //获取断开点指针
        while (breakPoint.next != null) {
            if (breakStart == breakPointIndex) {
                newHead.next = breakPoint.next;
                break;
            }
            breakPoint = breakPoint.next;
            breakStart++;
        }
        //将两个链表拼接
        end.next = head;
        breakPoint.next = null;
        return newHead.next;
    }

}
