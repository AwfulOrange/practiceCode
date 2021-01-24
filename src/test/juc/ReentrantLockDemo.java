package test.juc;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author chenxiangge
 * @Date 2020/8/13
 */

class Phone implements Runnable {
    public synchronized void sendSMS() throws Exception {
        //synchronized 可重入例子
        System.out.println(Thread.currentThread().getName() + "\t invoked sendSMS");
        sendEmail();
    }

    public synchronized void sendEmail() throws Exception {
        System.out.println(Thread.currentThread().getName() + "\t ########## invoked sendEmail");
    }

    //========================================

    Lock lock = new ReentrantLock();

    @Override
    public void run() {
        //ReentrantLock 可重入例子
        get();
    }

    public void get() {
        //无论加几把锁，只要配对均可执行
        //若锁不配对，则会造成程序卡死
        //上一个线程没有正确释放锁，下一个线程无法获得锁
        lock.lock();
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "\t invoke get()");
            set();
        } finally {
            lock.unlock();
            lock.unlock();
        }
    }

    public void set() {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "\t ############### invoke set()");
        } finally {
            lock.unlock();
        }
    }


}

/**
 * 同一个线程外层函数获取锁之后，内层递归函数仍能获取锁的代码
 * 同一个线程在外层方法获取锁的时候，进入内层方法会自动获取锁
 *
 * e.g.进入了大门之后（外层加锁方法）进入里面的房间不需要再获取锁（内层方法）
 *
 * 线程可以进入任何一个它已经拥有的锁(同一个锁)所同步着的代码块？
 * <p>
 * t1	 invoked sendSMS  t1线程在外层获取锁的时候
 * t1	 ########## invoked sendEmail 在进入内层方法会自动获取锁
 * t2	 invoked sendSMS
 * t2	 ########## invoked sendEmail
 */
public class ReentrantLockDemo {

    public static void main(String[] args) {
        Phone phone = new Phone();

        Thread t3 = new Thread(phone);
        Thread t4 = new Thread(phone);

        t3.start();
        t4.start();


        //
        new Thread(() -> {
            try {
                phone.sendSMS();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "t1").start();

        new Thread(() -> {
            try {
                phone.sendSMS();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "t2").start();
    }


//    volatile int n = 0;
//
//    public void add() {
//        n++;
//    }
//
//    public static void main(String[] args) {
//        ReentrantLock lock = new ReentrantLock(true);
//    }
}
