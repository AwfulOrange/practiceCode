package test.juc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Author chenxiangge
 * @Date 2020/8/19
 * <p>
 * //查看当前核心线程数量
 * //1核心-2线程
 * System.out.println(Runtime.getRuntime().availableProcessors());
 * <p>
 * //添加了s的是工具类
 * //Array Arrays
 * //Collection Collections
 * //Executor Executors
 */
public class MyThreadPoolDemo {
    public static void main(String[] args) {
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(2,
                5,
                1,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<Runnable>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.DiscardPolicy());

        for (int i = 0; i < 10; i++) {
            threadPool.execute(() -> {
                System.out.println(Thread.currentThread().getName() + "\t 办理业务");
            });
        }
        //需要关闭连接池
        threadPool.shutdown();

    }

    private static void threadPoolInitJDK() {
//        ExecutorService threadPool = Executors.newFixedThreadPool(5); //一池5个处理线程
//        ExecutorService threadPool = Executors.newCachedThreadPool();//一池N个处理线程
        ExecutorService threadPool = Executors.newSingleThreadExecutor();//一池1个处理线程

        for (int i = 0; i < 10; i++) {
            threadPool.execute(() -> {
                System.out.println(Thread.currentThread().getName() + "\t 办理业务");
            });
        }
        //需要关闭连接池
        threadPool.shutdown();
    }

}
