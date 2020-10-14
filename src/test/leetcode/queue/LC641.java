package test.leetcode.queue;

/**
 * @Author chenxiangge
 * @Date 2019/7/29
 */
public class LC641 {
    static class MyCircularDeque {
        private int size = 0;
        private int[] queue;
        private int head = 0;
        private int tail = 0;

        /**
         * Initialize your data structure here. Set the size of the deque to be k.
         */
        public MyCircularDeque(int k) {
            queue = new int[k];
        }

        /**
         * Adds an item at the front of Deque. Return true if the operation is successful.
         */
        public boolean insertFront(int value) {
            if (isFull()) {
                return false;
            }
            queue[tail] = value;
            tail = (tail + 1) % queue.length;
            size++;
            return true;
        }

        /**
         * Adds an item at the rear of Deque. Return true if the operation is successful.
         */
        public boolean insertLast(int value) {
            if (isFull()) {
                return false;
            }
            queue[head] = value;
            head = (head + 1) % queue.length;
            size++;
            return true;
        }

        /**
         * Deletes an item from the front of Deque. Return true if the operation is successful.
         */
        public boolean deleteFront() {
            if (isEmpty()) {
                return false;
            }
            head++;
            head = (head + 1) % queue.length;
            size--;
            return true;
        }

        /**
         * Deletes an item from the rear of Deque. Return true if the operation is successful.
         */
        public boolean deleteLast() {
            if (isEmpty()) {
                return false;
            }
            tail--;
            size--;
            return true;
        }

        /**
         * Get the front item from the deque.
         */
        public int getFront() {
            return queue[head];

        }

        /**
         * Get the last item from the deque.
         */
        public int getRear() {
            return queue[tail];
        }

        /**
         * Checks whether the circular deque is empty or not.
         */
        public boolean isEmpty() {
            return size == 0;
        }

        /**
         * Checks whether the circular deque is full or not.
         */
        public boolean isFull() {
            return size == queue.length;

        }

        public static void main(String[] args) {
            MyCircularDeque obj = new MyCircularDeque(3);
            obj.insertLast(1);
            obj.insertLast(2);
            obj.insertFront(3);
            obj.insertFront(4);
            obj.getRear();
            obj.isFull();
            obj.deleteLast();
            obj.insertFront(4);
            System.out.println(obj.getFront());
        }
    }

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */
}
