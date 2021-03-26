package test.leetcode.linkedlist;

import java.util.Stack;

/**
 * @Author chenxiangge
 * @Date 2020/4/14
 */
public class LC445 {
    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            Stack<Integer> number1 = new Stack<>();
            Stack<Integer> number2 = new Stack<>();
            //将链表的值放入stack，方便计算
            while (l1 != null) {
                number1.push(l1.val);
                l1 = l1.next;
            }

            while (l2 != null) {
                number2.push(l2.val);
                l2 = l2.next;
            }
            ListNode head = null;
            //进位标志
            int carry = 0;

            while (!number1.isEmpty() || !number2.isEmpty() || carry != 0) {

                int nu1 = 0;
                int nu2 = 0;
                if (!number1.isEmpty()) {
                    nu1 = number1.pop();
                }

                if (!number2.isEmpty()) {
                    nu2 = number2.pop();
                }

                int sum = nu1 + nu2 + carry;
                carry = sum / 10;

                ListNode node = new ListNode(sum % 10);
                node.next = head;
                head = node;

            }
            return head;
        }
    }
}
