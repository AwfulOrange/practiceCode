package test.leetcode.multithread;

import java.util.concurrent.Semaphore;

/**
 * @Author chenxiangge
 * @Date 2019/7/26
 */
public class LC1117 {
    class H2O {

        public H2O() {
        }

        private Semaphore h = new Semaphore(2);
        private Semaphore o = new Semaphore(1);

        public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
            h.acquire(1);
            releaseHydrogen.run();
            o.release(1);
        }

        public void oxygen(Runnable releaseOxygen) throws InterruptedException {
            o.acquire(2);
            releaseOxygen.run();
            h.release(2);
        }
    }
}
