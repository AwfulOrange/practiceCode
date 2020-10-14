package test.juc;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * @Author chenxiangge
 * @Date 2020/8/19
 * <p>
 * Q:三种获得多线程的方式
 * 1、new Thread
 * 2、实现Runnable接口
 * 3、Callable接口
 */
class MyThread implements Runnable {
    //1、没有返回值
    //2、不抛出异常
    @Override
    public void run() {

    }
}

class MyThread2 implements Callable<String> {
    //1、有返回值（根据泛型）
    //2、抛出异常
    @Override
    public String call() throws Exception {
        System.out.println(Thread.currentThread().getName() + "\t ========== in callable");
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "\t ========== out callable");
        return "1024";
    }
}


public class CallableDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        //Q1:Thread没有接受Callable的的构造方法，那么如何使用Callable创建Thead()?
        //A1: FutureTask 提供了Callable的构造器（面向接口编程的好处-适配）

        //Q：已经有Runnable 为什么需要Callable?
        //A: Callable有返回值，Runnable 无法提供返回值


        //fork-join框架的前身
        //先声明线程，由其异步执行,然后通过futureTask.get()获取最后结果
        FutureTask<String> futureTask = new FutureTask<>(new MyThread2());
        FutureTask<String> futureTask2 = new FutureTask<>(new MyThread2());
        Thread t1 = new Thread(futureTask, "AA");
        Thread t2 = new Thread(futureTask, "BB");
        t1.start();
        t2.start();
        //两个线程执行同一个futureTask，只会执行一次，先到先得（futureTask不重复执行）


        try {
            System.out.println(Thread.currentThread().getName() + "\t  sleep in=================");
            TimeUnit.SECONDS.sleep(2);
            System.out.println(Thread.currentThread().getName() + "\t sleep out=================");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //直接futureTask的完成状态，再进行响应的逻辑
//        while (!futureTask.isDone()){
//
//        }

        //获取callable线程的计算结果，如果执行时还没有完成，则会造成线程阻塞，一直等到任务执行完成后再执行主线程，一般放在最后执行
        System.out.println("res:" + futureTask.get());
    }
}
