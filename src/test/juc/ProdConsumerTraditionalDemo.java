package test.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author chenxiangge
 * @Date 2020/8/18
 * <p>
 * 生产商-消费者模式-传统版本
 * <p>
 * Q:一个初始值为0的变量，一个线程加1 一个线程减1，来5轮
 * <p>
 * 1、线程 操纵 资源类
 * 创建一个资源类，线程对其进行操作
 * 2、判断 干活 通知
 * 3、防止虚假唤醒机制
 * 多线程的判断必须使用while循环（防止虚假唤醒，线程数量大于2时使用if判断会有问题）
 */

class ShareData { // 资源类
    private int num = 0;
    /**
     * 多线程编程，必定涉及资源类的争抢，需要加锁来保证资源的同步。
     */
    private final Lock lock = new ReentrantLock();
    //??这个是什么
    private final Condition condition = lock.newCondition();

    public void increment() throws Exception {
        lock.lock();
        try {
            while (num != 0) {
                //1、判断-等待，已经存在，不需求再生产，直接等待生产者消费（等）。
                condition.await();
            }

            //2、干活
            num++;
            System.out.println(Thread.currentThread().getName() + "\t" + num);

            //3、通知-唤醒
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }


    public void decrement() throws Exception {
        lock.lock();
        try {
            while (num == 0) {
                //1、判断-等待，数字为0，不需要再进行消费 等待生产者生产。
                condition.await();
            }

            //2、干活
            num--;
            System.out.println(Thread.currentThread().getName() + "\t" + num);

            //3、通知-唤醒
            condition.signalAll();
        } catch (Exception e) {
            //todo handle exception

        } finally {
            lock.unlock();
        }
    }

}


public class ProdConsumerTraditionalDemo {
    public static void main(String[] args) {
        ShareData shareData = new ShareData();

        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    shareData.increment();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "AAA").start();


        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    shareData.decrement();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "BBB").start();

    }
}
