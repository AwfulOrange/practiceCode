package test.leetcode.multithread;

import java.util.concurrent.Semaphore;

/**
 * @Author chenxiangge
 * @Date 2019/7/26
 */
public class LC1114 {
    class Foo {
        //todo 设置信号量为0，则可先relase再acquire
        public Semaphore seam_first_two = new Semaphore(0);

        public Semaphore seam_two_second = new Semaphore(0);

        public Foo() {


        }

        public void first(Runnable printFirst) throws InterruptedException {

            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            seam_first_two.release();
        }

        public void second(Runnable printSecond) throws InterruptedException {

            // printSecond.run() outputs "second". Do not change or remove this line.
            seam_first_two.acquire();
            printSecond.run();
            seam_two_second.release();
        }

        public void third(Runnable printThird) throws InterruptedException {
            seam_two_second.acquire();
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
        }
    }
}
