package test.leetcode.stack;

import java.util.Stack;

/**
 * @Author chenxiangge
 * @Date 2019/7/29
 */
public class LC1047 {
    static class Solution {
        public String removeDuplicates(String S) {
            // Initialize a stack to be used in the algorithm.
            Stack<Character> stack = new Stack<>();
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < S.length(); i++) {
                if (!stack.isEmpty() && S.charAt(i) == stack.peek()) {
                    stack.pop();
                    sb.delete(sb.length() - 1, sb.length());
                    continue;
                }
                stack.push(S.charAt(i));
                sb.append(S.charAt(i));
            }

            return sb.toString();

        }
    }
}
