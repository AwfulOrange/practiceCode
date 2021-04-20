package test.leetcode.concurrent;

import java.util.concurrent.Semaphore;

/**
 * @Author chenxiangge
 * @Date 2021/4/12
 */
public class LC1117 {
    private Semaphore os = new Semaphore(0);
    private Semaphore hs = new Semaphore(2);

    volatile int hNum = 0;

    public LC1117() {

    }

    //一个O必须等到两个H
    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        hs.acquire();
        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        releaseHydrogen.run();
        hNum++;
        //释放两个H后才可以释放O
        if (hNum == 2) {
            os.release();
        }
    }


    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        os.acquire();
        // releaseOxygen.run() outputs "O". Do not change or remove this line.
        releaseOxygen.run();
        //释放过O之后，H重新计数
        hNum = 0;
        //又可以再次获取两个H
        hs.release(2);
    }
}
