package test.leetcode.multithread;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

/**
 * @Author chenxiangge
 * @Date 2019/7/26
 */
public class LC1116 {
    static class ZeroEvenOdd {

        //0->even->0->odd
        //循环打印2n
        public Semaphore seam_zero_odd = new Semaphore(0);

        public Semaphore seam_zero_even = new Semaphore(0);

        public Semaphore seam_zero = new Semaphore(1);


        private int n;

        public ZeroEvenOdd(int n) {
            this.n = n;
        }

        // printNumber.accept(x) outputs "x", where x is an integer.
        public void zero(IntConsumer printNumber) throws InterruptedException {
            for (int i = 1; i <= n; i++) {
                seam_zero.acquire();
                printNumber.accept(0);
                if (i % 2 == 0) {
                    seam_zero_even.release();
                }else{
                    seam_zero_odd.release();
                }
            }

        }

        public void even(IntConsumer printNumber) throws InterruptedException {
            for (int i = 2; i <= n; i = i + 2) {
                seam_zero_even.acquire();
                printNumber.accept(i);
                seam_zero.release();

            }


        }

        public void odd(IntConsumer printNumber) throws InterruptedException {
            for (int i = 1; i <= n; i = i + 2) {
                seam_zero_odd.acquire();
                printNumber.accept(i);
                seam_zero.release();
            }

        }
    }

    public static void main(String[] args) {
        ZeroEvenOdd zeroEvenOdd = new ZeroEvenOdd(10);

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    zeroEvenOdd.zero(x -> System.out.print(x));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    zeroEvenOdd.even(x -> System.out.print(x));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    zeroEvenOdd.odd(x -> System.out.print(x));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
