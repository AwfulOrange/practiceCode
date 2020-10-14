package test.jvm.reference;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/**
 * @Author chenxiangge
 * @Date 2020/9/1
 */
public class PhantomReferenceDemo {
    public static void main(String[] args) throws InterruptedException {
        Object o1 = new Object();
        ReferenceQueue<Object> objectReferenceQueue = new ReferenceQueue<>();
        //创建对象时指定GC释放内存后进入的引用队列
        PhantomReference<Object> phantomReference = new PhantomReference<>(o1,objectReferenceQueue);

        System.out.println(o1);
        //虚引用的get方法返回总是null-形同虚设
        System.out.println(phantomReference.get());
        System.out.println(objectReferenceQueue.poll());

        System.out.println("===================");

        o1=null;
        System.gc();
        // System.gc()调用后不是马上执行，所以需要sleep
        Thread.sleep(500);


        System.out.println(o1);
        System.out.println(phantomReference.get());
        //从引用队列中获取内容（确认垃圾回收后的对象是否被放入引用队列）
        //spring中的后置通知（afterDestroy）
        //通过这种方式，JVM允许我们在对象被销毁后，做一些我们自己想做的事情
        System.out.println(objectReferenceQueue.poll());

    }
}
