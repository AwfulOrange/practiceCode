package test.juc;

import sun.applet.AppletResourceLoader;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author chenxiangge
 * @Date 2020/8/18
 * <p>
 * Q:多线程之间按顺序调用，实现A->B->C三个线程启动，要求如下：
 * A打印5次，B打印10次，C打印15次
 * 紧接着
 * A打印5次，B打印10次，C打印15次
 * ...
 * 循环10轮
 */

class SynchronizedLockDemoShareData {
    //线程标志位
    private int num = 1;//1-A 2-B 3-C
    private Lock lock = new ReentrantLock();

    // Where a Lock replaces the use of synchronized methods and statements, a Condition replaces the use of the Object monitor methods.
    private Condition c1 = lock.newCondition();
    private Condition c2 = lock.newCondition();
    private Condition c3 = lock.newCondition();

    public void print5() {
        lock.lock();
        try {
            //1、判断
            //为防止虚假唤醒，使用while循环
            while (num != 1) {
                c1.await();
            }

            //2、干活
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i);
            }

            //3、通知（通知下一个线程干活）
            //修改标识位
            num = 2;
            c2.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void print10() {
        lock.lock();
        try {
            //1、判断
            //为防止虚假唤醒，使用while循环
            while (num != 2) {
                c2.await();
            }

            //2、干活
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i);
            }

            //3、通知（通知下一个线程干活）
            //修改标识位
            num = 3;
            c3.signal();
        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            lock.unlock();
        }
    }

    public void print15() {
        lock.lock();
        try {
            //1、判断
            //为防止虚假唤醒，使用while循环
            while (num != 3) {
                c3.await();
            }

            //2、干活
            for (int i = 0; i < 15; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i);
            }

            //3、通知（通知下一个线程干活）
            //修改标识位
            num = 1;
            //精确唤醒
            c1.signal();
        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            lock.unlock();
        }
    }

}

public class SynchronizedLockDemo {
    public static void main(String[] args) {

        SynchronizedLockDemoShareData synchronizedLockDemoShareData = new SynchronizedLockDemoShareData();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                synchronizedLockDemoShareData.print5();
            }
        },"A").start();


        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                synchronizedLockDemoShareData.print10();
            }
        },"B").start();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                synchronizedLockDemoShareData.print15();
            }
        },"C").start();
    }
}
