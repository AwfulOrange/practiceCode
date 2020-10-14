package test.leetcode.stack;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author chenxiangge
 * @Date 2019/7/30
 */
public class LC225 {
    class MyStack {
        List<Integer> stack;
        Integer top;

        /**
         * Initialize your data structure here.
         */
        public MyStack() {
            this.stack = new ArrayList<>();
        }

        /**
         * Push element x onto stack.
         */
        public void push(int x) {
            stack.add(x);
            top = x;

        }

        /**
         * Removes the element on top of the stack and returns that element.
         */
        public int pop() {
            if (stack.isEmpty()) {
                throw new RuntimeException("栈中元素为空，此操作非法");
            }
            int res = stack.get(stack.size() - 1);
            stack.remove(stack.size() - 1);
            //top修改
            if (!stack.isEmpty()) {
                top = stack.get(stack.size() - 1);
            }
            return res;

        }

        /**
         * Get the top element.
         */
        public int top() {
            if (stack.isEmpty()) {
                throw new RuntimeException("栈中元素为空，此操作非法");
            }
            return top;

        }

        /**
         * Returns whether the stack is empty.
         */
        public boolean empty() {
            return stack.isEmpty();

        }
    }

}
