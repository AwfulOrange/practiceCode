package test.interview.i2021;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 3组线程让线程等待/唤醒的方法
 *
 * @Author chenxiangge
 * @Date 1/25/21
 */
public class LockSupportDemo {
    static Object objectLock = new Object();

    static Lock lock = new ReentrantLock();
    static Condition condition = lock.newCondition();

    public static void main(String[] args) {


        lockSupportDemo();


//        objectWaitNotify();
//        conditionWaitSignal();

    }

    /**
     * lockSupport park()&unpark()
     * 1、没有先后调用问题
     * 2、不需要在同步代码块中执行
     * 3、直接使用了UNSAFE类中的底层代码
     */
    private static void lockSupportDemo() {
        Thread a = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() +"-- come in");
            LockSupport.park(); //阻塞 等待许可证
            System.out.println(Thread.currentThread().getName() +"--first unpark");
            LockSupport.park();//阻塞 等待许可证
            System.out.println(Thread.currentThread().getName() +"-- wake up");
        }, "A");
        a.start();

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Thread b = new Thread(() -> {
            LockSupport.unpark(a);//发放许可证-最多只发放一个
            LockSupport.unpark(a);//发放许可证-最多只发放一个
            System.out.println(Thread.currentThread().getName() +"-- wake");
        }, "B");
        b.start();
    }

    /**
     * 2、Condition await() & signal()
     * <p>
     * 注意点1：signal&await必须在synchronized代码块/锁范围中中使用（字节码层面，需要搭配monitorEnter&monitorExit）
     * （The current thread must own this object's monitor/当前线程必须持有当前对象锁）否则代码将抛出异常
     * <p>
     * 注意点2：必须先await再signal
     * 注意点3：与Object不同，condition的出现可以使每个对象存在多个等待集
     */
    private static void conditionWaitSignal() {
        new Thread(() -> {
//            lock.lock();
            try {
                System.out.println(Thread.currentThread().getName() + "\t" + "----in");
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "\t" + "----wake up");
            } finally {
//                lock.unlock();
            }
        }, "A").start();


        new Thread(() -> {
            //如果是先执行notify再执行wait则线程会一直处于卡死状态
//            lock.lock();
            try {
                condition.signal();
                System.out.println(Thread.currentThread().getName() + "\t" + "----wake");
            }  finally {
//                lock.unlock();
            }

        }, "B").start();
    }


    /**
     * 1、Object wait() & notify()
     * <p>
     * 注意点1：wait&notify必须在synchronized代码块中使用（字节码层面，需要搭配monitorEnter&monitorExit）
     * （The current thread must own this object's monitor/当前线程必须持有当前对象锁）否则代码将抛出异常
     * <p>
     * 注意点2：必须先wait再notify
     */
    private static void objectWaitNotify() {
        new Thread(() -> {
            //如果是先执行notify再执行wait则线程会一直处于卡死状态
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (objectLock) {
                System.out.println(Thread.currentThread().getName() + "\t" + "----in");
                try {
                    objectLock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "\t" + "----wake up");

            }

        }, "A").start();


        new Thread(() -> {
            synchronized (objectLock) {
                objectLock.notify();
                System.out.println(Thread.currentThread().getName() + "\t" + "----wake");
            }

        }, "B").start();
    }
}
