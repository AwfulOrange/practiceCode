package test.leetcode.stack;

import java.util.Stack;

/**
 * @Author chenxiangge
 * @Date 4/1/21
 */
public class LC1106 {
    public static int clumsy(int N) {
        Stack<Integer> stack = new Stack<>();
        int length = N;
        stack.push(N);
        N--;
        for (int i = 0; i < length - 1; i++) {
            //乘法&除法 直接操作
            //加法&减法 入栈 稍后再进行操作
            int count = i % 4;
            switch (count) {
                case 0:
                    stack.push(stack.pop() * N);
                    break;
                case 1:
                    stack.push(stack.pop() / N);
                    break;
                case 2:
                    stack.push(N);
                    break;
                case 3:
                    stack.push(-N);
                    break;
            }
            N--;
        }
        Integer res = 0;
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(clumsy(10));
    }
}
