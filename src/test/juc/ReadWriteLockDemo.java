package test.juc;

import test.leetcode.java8.delayList.MyLinkedList;
import test.leetcode.proxy.Obj;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Author chenxiangge
 * @Date 2020/8/14
 * <p>
 * 多个线程同时读取一个资源类没有任何问题，为了满足并发量，读取共享资源应该可以同时进行。
 * 但是
 * 如果有一个线程想去写共享资源，就不应该再有其他线程可以对该资源进行读或写
 * 总结
 * 读-读：可以共存
 * 读-写：不可共存
 * 写-写：不可共存
 * 写操作：原子+独占（不可中断）:整个过程必须为统一体，中间不允许被打断&加塞
 */

class MyCache {
    private volatile Map<String, Object> map = new HashMap<>();
    private ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();

    /**
     * 缓存框架基本操作
     * 1、读
     * 2、写
     * 3、清空
     */
    public void put(String key, Object object) {
        reentrantReadWriteLock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "\t 开始写入");
            map.put(key, object);
            System.out.println(Thread.currentThread().getName() + "\t 写入完成");
        } catch (Exception e) {
            //todo handle exception
            e.printStackTrace();
        } finally {
            reentrantReadWriteLock.writeLock().unlock();
        }

    }

    public void get(String key) {
        reentrantReadWriteLock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "\t 开始读取");
            Object result = map.get(key);
            System.out.println(Thread.currentThread().getName() + "\t 读取完成 result:" + result);
        } catch (Exception e) {
            //todo handle exception
            e.printStackTrace();
        } finally {
            reentrantReadWriteLock.readLock().unlock();
        }
    }
}

public class ReadWriteLockDemo {
    public static void main(String[] args) {
        MyCache cache = new MyCache();
        ReentrantLock lock = new ReentrantLock();
        for (int i = 0; i < 5; i++) {
            final String tempI = String.valueOf(i);
            new Thread(() -> {
                cache.put(tempI, tempI);
            }, String.valueOf(i) + " write").start();

        }
        for (int i = 0; i < 5; i++) {
            final String tempI = String.valueOf(i);
            new Thread(() -> {
                cache.get(tempI);
            }, String.valueOf(i) + " read").start();

        }
    }
}
