package test.juc;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author chenxiangge
 * @Date 2020/8/11
 */
public class CASDemo {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(5);

        atomicInteger.getAndIncrement();



    }
}
