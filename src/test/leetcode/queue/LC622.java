package test.leetcode.queue;

/**
 * @Author chenxiangge
 * @Date 2019/9/6
 */
public class LC622 {
    static class MyCircularQueue {

        private int head = 0;//头部数据所在数组位置
        private int tail = 0;//尾部数据所在数组位置
        private int size;
        private int[] queue;

        /**
         * Initialize your data structure here. Set the size of the queue to be k.
         */
        public MyCircularQueue(int k) {
            queue = new int[k];
        }

        /**
         * Insert an element into the circular queue. Return true if the operation is successful.
         */
        public boolean enQueue(int value) {
            if (isFull()) {
                return false;
            }
            queue[tail] = value;
            tail = (tail + 1) % queue.length;
            size++;
            return true;
        }

        /**
         * Delete an element from the circular queue. Return true if the operation is successful.
         */
        public boolean deQueue() {
            if (isEmpty()) {
                return false;
            }
            head = (head + 1) % queue.length;
            size--;
            return true;

        }

        /**
         * Get the front item from the queue.
         */
        public int Front() {
            if (isEmpty()) {
                return -1;
            }
            return queue[head];
        }

        /**
         * Get the last item from the queue.
         */
        public int Rear() {
            if (isEmpty()) {
                return -1;
            }
            // 队尾元素位于队尾索引值减一的位置，但若队尾循环到索引 0 的位置，队尾元素位于数组最后
            else {
                int temp = tail == 0 ? (queue.length - 1) : (tail - 1);
                return queue[temp];
            }
        }

        /**
         * Checks whether the circular queue is empty or not.
         */
        public boolean isEmpty() {
            return size == 0;
        }

        /**
         * Checks whether the circular queue is full or not.
         */
        public boolean isFull() {
            return size == queue.length;
        }
    }

    public static void main(String[] args) {
        MyCircularQueue obj = new MyCircularQueue(3);
        boolean param_1 = obj.enQueue(2);
        int param_2 = obj.Rear();
        int param_3 = obj.Front();
        boolean param_4 = obj.deQueue();
        int param_5 = obj.Front();
        boolean param_6 = obj.deQueue();
        int param_7 = obj.Front();
        boolean param_8 = obj.enQueue(4);
        boolean param_9 = obj.enQueue(2);
        boolean param_10 = obj.enQueue(2);
        boolean param_11 = obj.enQueue(3);
    }

//    ["MyCircularQueue","enQueue","Rear","Front","deQueue","Front","deQueue","Front","enQueue","enQueue","enQueue","enQueue"]
//            [[3],[2],[],[],[],[],[],[],[4],[2],[2],[3]]


/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
}
