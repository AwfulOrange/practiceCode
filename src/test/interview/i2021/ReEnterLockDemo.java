package test.interview.i2021;

/**
 * @Author chenxiangge
 * @Date 2021/1/24
 */
public class ReEnterLockDemo {
    private static Object lockA = new Object();

    private static void m1() {
        new Thread(() -> {
            synchronized (lockA) {
                System.out.println(Thread.currentThread().getName() + "------外层调用");
                synchronized (lockA){
                    System.out.println(Thread.currentThread().getName() + "------中层调用");
                    synchronized (lockA){
                        System.out.println(Thread.currentThread().getName() + "------内层调用");
                    }
                }
            }
        }, "threadDemo").start();
    }

    private static synchronized void m2(){
        System.out.println("外层调用");
        m3();
    }

    private static synchronized void m3() {
        System.out.println("中层调用");
        m4();
    }

    private static void m4() {
        System.out.println("内层调用");
    }

    public static void main(String[] args) {
        //同步代码块
        m1();
        //同步方法
        m2();
    }
}
