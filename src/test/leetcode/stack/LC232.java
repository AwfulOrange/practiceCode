package test.leetcode.stack;

import java.util.Stack;

/**
 * @Author chenxiangge
 * @Date 2019/7/30
 */
public class LC232 {
    static class MyQueue {
        Stack<Integer> myQueue;
        Stack<Integer> temp;

        /**
         * Initialize your data structure here.
         */
        public MyQueue() {
            this.myQueue = new Stack<>();
            this.temp = new Stack<>();
        }

        /**
         * Push element x to the back of queue.
         */
        public void push(int x) {
            //将数组逆序放入temp
            while (!myQueue.isEmpty()) {
                temp.push(myQueue.pop());
            }
            myQueue.push(x);

            //再放回，则最早放入stack的已达到stack最后
            while (!temp.isEmpty()) {
                myQueue.push(temp.pop());
            }


        }

        /**
         * Removes the element from in front of queue and returns that element.
         */
        public int pop() {
            if (myQueue.isEmpty()) {
                throw new RuntimeException("栈中元素为空，此操作非法");
            }
            return myQueue.pop();

        }

        /**
         * Get the front element.
         */
        public int peek() {
            if (myQueue.isEmpty()) {
                throw new RuntimeException("栈中元素为空，此操作非法");
            }
            return myQueue.peek();
        }

        /**
         * Returns whether the queue is empty.
         */
        public boolean empty() {
            return myQueue.isEmpty();

        }
    }

    /**
     * Your MyQueue object will be instantiated and called as such:
     * MyQueue obj = new MyQueue();
     * obj.push(x);
     * int param_2 = obj.pop();
     * int param_3 = obj.peek();
     * boolean param_4 = obj.empty();
     */

    public static void main(String[] args) {
        MyQueue obj = new MyQueue();
        obj.push(1);
        obj.push(2);
        System.out.println(obj.peek());
        System.out.println(obj.pop());
        System.out.println(obj.empty());
    }


}
