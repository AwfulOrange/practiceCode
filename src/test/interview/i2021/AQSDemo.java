package test.interview.i2021;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author chenxiangge
 * @Date 1/27/21
 */
public class AQSDemo {
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();

        /**
         * 银行顾客等待业务办理
         */
        new Thread(() -> {
            //获取锁
            lock.lock();
            try {
                System.out.println(Thread.currentThread().getName() + "------- in");
                //办理5分钟的业务
                try {
                    TimeUnit.MINUTES.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } finally {
                //办理完成释放锁
                lock.unlock();
            }


        }, "A").start();


        new Thread(() -> {
            //获取锁
            lock.lock();
            try {
                System.out.println(Thread.currentThread().getName() + "------- in");
            } finally {
                //办理完成释放锁
                lock.unlock();
            }


        }, "B").start();

        new Thread(() -> {
            //获取锁
            lock.lock();
            try {
                System.out.println(Thread.currentThread().getName() + "------- in");
            } finally {
                //办理完成释放锁
                lock.unlock();
            }


        }, "C").start();
    }
}
