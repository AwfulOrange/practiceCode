package test.leetcode.concurrent;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

/**
 * @Author chenxiangge
 * @Date 2021/4/12
 */
public class LC1116 {
    public Semaphore zero = new Semaphore(1);
    public Semaphore even = new Semaphore(0);
    public Semaphore odd = new Semaphore(0);
    private int n;

    public LC1116(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {

        for (int i = 1; i <= n; i++) {
            zero.acquire(1);
            printNumber.accept(0);
            if (i % 2 == 0) {
                //先奇数，再偶数
                even.release();
            } else {
                odd.release();
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 2; i <= n; i = i + 2) {
            even.acquire();
            printNumber.accept(i);
            zero.release();
        }

    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i = i + 2) {
            odd.acquire();
            printNumber.accept(i);
            zero.release();
        }
    }

    public static void main(String[] args) {
        LC1116 lc1116 = new LC1116(2);
        new Thread(() -> {
            try {
                lc1116.zero(System.out::println);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, String.valueOf("0")).start();

        new Thread(() -> {
            try {
                lc1116.odd(System.out::println);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, String.valueOf("1")).start();

        new Thread(() -> {
            try {
                lc1116.even(System.out::println);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, String.valueOf("3")).start();
    }
}
