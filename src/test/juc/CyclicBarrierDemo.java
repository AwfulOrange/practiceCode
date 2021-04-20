package test.juc;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

/**
 * @Author chenxiangge
 * @Date 2020/8/14
 */
public class CyclicBarrierDemo {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(7, () -> {
            System.out.println("收集到7颗龙珠");
        });

        for (int i = 0; i < 14; i++) {
            final int tempi = i;
            new Thread(() -> {
                System.out.println("收集到第" + tempi + "颗龙珠");
                try {
                    cyclicBarrier.await();
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("收集完毕" + tempi + "颗龙珠");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }, String.valueOf(i)).start();
        }

        new Thread(() -> {
            System.out.println("开始还原");
            cyclicBarrier.reset();
        }, String.valueOf(99)).start();


    }
}
