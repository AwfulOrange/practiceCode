package test.jvm.reference;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/**
 * @Author chenxiangge
 * @Date 2020/9/1
 */
public class ReferenceQueueDemo {
    public static void main(String[] args) throws InterruptedException {
        Object o1 = new Object();
        ReferenceQueue<Object> objectReferenceQueue = new ReferenceQueue<>();
        WeakReference<Object> weakReference = new WeakReference<>(o1,objectReferenceQueue);

        System.out.println(o1);
        System.out.println(weakReference.get());
        System.out.println(objectReferenceQueue.poll());

        System.out.println("===================");

        o1=null;
        System.gc();
        // System.gc()调用后不是马上执行，所以需要sleep
        Thread.sleep(500);


        System.out.println(o1);
        System.out.println(weakReference.get());
        //从引用队列中获取内容（确认垃圾回收后的对象是否被放入引用队列）
        //spring中的后置通知（afterDestroy）
        System.out.println(objectReferenceQueue.poll());

    }
}
