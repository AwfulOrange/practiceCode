package test.juc;

/**
 * @Author chenxiangge
 * @Date 2020/8/20
 * <p>
 * 死锁是指两个或康哥以上的进程在执行过程中，
 * 因争夺资源而造成的一种互相等待的现象
 * 若无外力干涉那它们将无法推进下去
 */
class HoldLockThread implements Runnable {
    private final String lockA;
    private final String lockB;

    public HoldLockThread(String lockA, String lockB) {
        this.lockA = lockA;
        this.lockB = lockB;
    }

    @Override
    public void run() {
        synchronized (lockA) {
            System.out.println(Thread.currentThread().getName() + "\t 持有" + lockA + "准备获取" + lockB);
            synchronized (lockB) {
                System.out.println(Thread.currentThread().getName() + "\t 持有" + lockB + "准备获取" + lockA);
            }
        }

    }
}

public class DeadLockDemo {
    public static void main(String[] args) {
        String lockA = "lockA";
        String lockB = "lockB";
        new Thread(new HoldLockThread(lockA,lockB),"AAA").start();
        new Thread(new HoldLockThread(lockB,lockA),"BBB").start();
    }
}
