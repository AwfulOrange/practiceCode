package test.juc;

import java.util.concurrent.CountDownLatch;

/**
 * @Author chenxiangge
 * @Date 2020/8/14
 */
public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(6);
        for (int i = 0; i < 6; i++) {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName() +"\t 上晚自习 离开教室");
                countDownLatch.countDown();
            },String.valueOf(i)).start();
        }
        countDownLatch.await();
        System.out.println(Thread.currentThread().getName() +"\t ==============班长锁门");
    }
}
