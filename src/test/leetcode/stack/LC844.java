package test.leetcode.stack;

import java.util.Stack;

/**
 * @Author chenxiangge
 * @Date 2019/7/31
 */
public class LC844 {
    public static boolean backspaceCompare(String S, String T) {
        Stack<Character> stackS = new Stack<>();
        Stack<Character> stackT = new Stack<>();
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (c == '#' && stackS.empty()) {
                continue;
            } else if (c == '#') {
                stackS.pop();
            } else {
                stackS.push(c);
            }

        }
        for (int i = 0; i < T.length(); i++) {
            char d = T.charAt(i);
            if (d == '#' && stackT.empty()) {
                continue;
            } else if (d == '#') {
                stackT.pop();
            } else {
                stackT.push(d);
            }
        }
        if (stackS.size() != stackT.size()) {
            return false;
        }
        boolean res = true;
        for (int i = 0; i < stackS.size(); i++) {
            if (stackS.pop() != stackT.pop()) {
                return false;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(backspaceCompare("y#fo##f",
                "y#f#o##f"));
    }
}
