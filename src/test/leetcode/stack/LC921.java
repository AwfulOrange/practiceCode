package test.leetcode.stack;

import java.util.Stack;

/**
 * @Author chenxiangge
 * @Date 2019/8/1
 */
public class LC921 {
    public static int minAddToMakeValid(String S) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '(') {
                stack.push(S.charAt(i));
            } else if (S.charAt(i) == ')') {
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                } else {
                    stack.push(S.charAt(i));
                }
            }
        }
        return stack.size();

    }
}
