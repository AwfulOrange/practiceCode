package test.juc;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author chenxiangge
 * @Date 2020/8/6
 */
public class VolatileTest {
    private volatile int i;

    private AtomicInteger integer;

    //不保证原子性，线程争抢，导致写丢失(从字节码中可以看出)
    //i++/++i最后都是一样的字节码展示形式 所以都是线程不安全的
    public void addI() {
        i++;
    }

    public void addAtomic() {
        integer.getAndIncrement();
        integer.compareAndSet(1,5);
    }
}
