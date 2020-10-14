package test.juc;

import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @Author chenxiangge
 * @Date 2020/8/14
 * <p>
 * 1、队列
 * <p>
 * 2、阻塞队列
 * 2.1 阻塞队列的好处？
 * 不需要关心何时阻塞线程，何时唤醒线程，一切交由BlockingQueue处理。（由手动挡升级为自动挡）
 * <p>
 * 2.2 要如何管理阻塞队列？
 */
public class BlockingDemo {
    public static void main(String[] args) throws InterruptedException {

//        List list = null;

        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);

        //超时操作（过期不侯）有效解决了使用put(),take()线程阻塞的问题
        System.out.println(blockingQueue.offer("a", 2, TimeUnit.SECONDS));
        System.out.println(blockingQueue.offer("a", 2, TimeUnit.SECONDS));
        System.out.println(blockingQueue.offer("a", 2, TimeUnit.SECONDS));

        System.out.println(blockingQueue.offer("a", 2, TimeUnit.SECONDS));






        //没有返回值的操作，当队列满时，一直处于阻塞状态（程序不会自动退出）put(),take()
//        blockingQueue.put("a");
//        blockingQueue.put("b");
//        blockingQueue.put("c");
//        System.out.println("==================");
//        blockingQueue.put("d");
//
//        blockingQueue.take();
//        blockingQueue.take();
//        blockingQueue.take();
//        blockingQueue.take();



//        //不抛出异常(返回布尔类型)的三个操作 offer(),peek(),poll()
//        System.out.println(blockingQueue.offer("a"));
//        System.out.println(blockingQueue.offer("b"));
//        System.out.println(blockingQueue.offer("c"));
//        System.out.println(blockingQueue.offer("d"));
//
//        System.out.println(blockingQueue.peek());
//
//        System.out.println(blockingQueue.poll());
//        System.out.println(blockingQueue.poll());
//        System.out.println(blockingQueue.poll());
//        System.out.println(blockingQueue.poll());


        //抛异常的三个操作 add(),element(),remove()
//        System.out.println(blockingQueue.add("a"));
//        System.out.println(blockingQueue.add("b"));
//        System.out.println(blockingQueue.add("c"));
//        //IllegalStateException: Queue full
////        System.out.println(blockingQueue.add("d"));
//
//        System.out.println(blockingQueue.element());
//
//        System.out.println(blockingQueue.remove());
//        System.out.println(blockingQueue.remove());
//        System.out.println(blockingQueue.remove());
        //NoSuchElementException
//        System.out.println(blockingQueue.remove());
    }
}
