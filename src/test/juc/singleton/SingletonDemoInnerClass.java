package test.juc.singleton;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 静态内部类形式的单例模式（代码层面更加简介）
 * 1、在内部类被加载和初始化时，才创建Instants实例对象
 * 2、静态内部类不会随着外部类的加载和初始化而初始化，他是单独加载和初始化（实现了延迟加载）
 * 3、因为是在内部类加载和初始化时创建的，所以时线程安全的（由类加载器控制）
 *
 * @Author chenxiangge
 * @Date 2/19/21
 */
public class SingletonDemoInnerClass {
    private SingletonDemoInnerClass() {
        //不允许外部调用
    }

    private static class InnerStatic {

        public InnerStatic() {
            System.out.println("构造器-正在创建静态内部类");
        }

        private static final SingletonDemoInnerClass INSTANCE = new SingletonDemoInnerClass();

    }

    private static class Inner {
        public Inner() {
            System.out.println("构造器-正在创建内部类");
        }

        private static final SingletonDemoInnerClass INSTANCE = new SingletonDemoInnerClass();
    }


    public static SingletonDemoInnerClass getInstants() {
        return InnerStatic.INSTANCE;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
       Callable<SingletonDemoInnerClass> classCallable = new Callable<SingletonDemoInnerClass>() {
           @Override
           public SingletonDemoInnerClass call() throws Exception {
               return SingletonDemoInnerClass.getInstants();
           }
       };

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        Future<SingletonDemoInnerClass> task1 = executorService.submit(classCallable);
        Future<SingletonDemoInnerClass> task2 = executorService.submit(classCallable);

        System.out.println(task1.get() == task2.get());
        System.out.println(task1.get());
        System.out.println(task2.get());

    }
}
