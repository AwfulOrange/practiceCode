package test.juc;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @Author chenxiangge
 * @Date 2020/8/13
 * <p>
 * 自己手写一个自旋锁
 * 自选的本质：while循环+CAS比较
 */
public class SpinLockDemo {

    //线程的原子引用
    AtomicReference<Thread> atomicReference = new AtomicReference<>();

    /**
     * 不断自旋+CAS获取锁
     * 获取锁
     */
    private void myLock() {
        Thread thread = Thread.currentThread();
        System.out.println(Thread.currentThread().getName() + "\t is coming");
        //空转 直到获取锁
        while (!atomicReference.compareAndSet(null, thread)) {

        }

    }

    /**
     * 解锁
     */
    private void myUnLock() {
        //直接将原子引用置为null？
        Thread thread = Thread.currentThread();
        //如果我已使用完成，则将当前的线程锁置为null
        atomicReference.compareAndSet(thread, null);
        System.out.println(Thread.currentThread().getName() + "\t invoked myUnlock()");

    }

    public static void main(String[] args) {
        SpinLockDemo spinLockDemo = new SpinLockDemo();
        new Thread(() -> {
            spinLockDemo.myLock();
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            spinLockDemo.myUnLock();

        }, "AAA").start();


        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(() -> {
            spinLockDemo.myLock();
            spinLockDemo.myUnLock();
        }, "BBB").start();
    }
}
