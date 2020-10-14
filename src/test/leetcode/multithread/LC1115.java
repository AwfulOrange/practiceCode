package test.leetcode.multithread;

import java.util.concurrent.Semaphore;

/**
 * @Author chenxiangge
 * @Date 2019/7/26
 */
public class LC1115 {
    static class FooBar {
        private int n;
        private Semaphore foo_bar = new Semaphore(0);
        //初始化为1，保证起始字符串为foo
        private Semaphore bar_foo = new Semaphore(1);


        public FooBar(int n) {
            this.n = n;
        }

        public void foo(Runnable printFoo) throws InterruptedException {
            for (int i = 0; i < n; i++) {
                // printFoo.run() outputs "foo". Do not change or remove this line.
                bar_foo.acquire();
                printFoo.run();
                foo_bar.release();
            }
        }

        public void bar(Runnable printBar) throws InterruptedException {
            for (int i = 0; i < n; i++) {
                foo_bar.acquire();
                // printBar.run() outputs "bar". Do not change or remove this line.
                printBar.run();
                bar_foo.release();
            }
        }
    }
}
