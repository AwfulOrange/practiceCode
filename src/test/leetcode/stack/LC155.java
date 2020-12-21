package test.leetcode.stack;

import java.util.Stack;

/**
 * @Author chenxiangge
 * @Date 2019/7/29
 */
public class LC155 {
    static class MinStack {
        private final Stack<Integer> dataStack;
        private final Stack<Integer> minStack;


        /**
         * initialize your data structure here.
         */
        public MinStack() {
            this.dataStack = new Stack<>();
            this.minStack = new Stack<>();

        }

        public void push(int x) {
            dataStack.push(x);
            if (minStack.isEmpty() || minStack.peek() >= x) {
                minStack.push(x);
            }
        }

        public void pop() {
            //Integer包装类型的比较！不能用==
            if (!minStack.isEmpty() && minStack.peek().equals(dataStack.peek())) {
                minStack.pop();
            }
            dataStack.pop();


        }

        public int top() {
            if (!dataStack.isEmpty()) {
                return dataStack.peek();
            }
            throw new RuntimeException("栈中元素为空，此操作非法");


        }

        public int getMin() {
            if (minStack.isEmpty()) {
                throw new RuntimeException("栈中元素为空，此操作非法");
            }
            return minStack.peek();
        }
    }

    public static void main(String[] args) {
        MinStack obj = new MinStack();
        obj.push(512);
        obj.push(-1024);
        obj.push(-1024);
        obj.push(512);
        obj.pop();
        System.out.println(obj.getMin());
        obj.pop();
        System.out.println(obj.getMin());
        obj.pop();
        System.out.println(obj.getMin());
    }
}
