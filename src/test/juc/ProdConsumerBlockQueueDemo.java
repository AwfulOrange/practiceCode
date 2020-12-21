package test.juc;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author chenxiangge
 * @Date 2020/8/18
 * 生产商消费者模式-阻塞队列版本（传统版本-@ProdConsumerTraditionalDemo）
 * 程序员不需要关心何时阻塞/唤醒线程，一切由blockingQueue包办
 */
class MyResource {
    //是否启动消费的flag-默认开启 进行生产和消费（高并发的程序需要保证其可见性）
    private volatile boolean FLAG = true;
    //用于消费生产的计数（高并发场景下，使用原子类型，不要使用i++/++i）
    private final AtomicInteger integer = new AtomicInteger();

    //适配所有阻塞队列
    BlockingQueue<String> blockingQueue = null;

    //构造注入方法(以传入的具体实现类为准)
    //传接口 具有更强的拓展性
    public MyResource(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
        //打印具体的类
        System.out.println(blockingQueue.getClass().getName());

    }

    public void myProd() throws Exception {
        String data = null;
        boolean retValue;
        while (FLAG) {
            data = integer.incrementAndGet() + "";
            retValue = blockingQueue.offer(data, 2, TimeUnit.SECONDS);
            if (retValue) {
                System.out.println(Thread.currentThread().getName() + "\t" + "插入队列成功 data:" + data);
            } else {
                System.out.println(Thread.currentThread().getName() + "\t" + "插入队列失败 data:" + data);
            }
            TimeUnit.SECONDS.sleep(1);
        }

        System.out.println(Thread.currentThread().getName() + "生产动作被中止 flag=false");
    }

    public void myConsumer() throws Exception {
        String retValue;
        while (FLAG) {
            retValue = blockingQueue.poll(2, TimeUnit.SECONDS);
            if (null == retValue || retValue.equalsIgnoreCase("")) {
                //队列中无元素，说明消费已结束（生产者不再生产）
                FLAG = false;
                System.out.println(Thread.currentThread().getName() + "\t" + "超过2s没有取到数据，消费退出");
                return;
            }
            System.out.println(Thread.currentThread().getName() + "\t" + "消费队列成功 data:" + retValue);
        }
    }

    public void stop(){
        FLAG = false;
    }
}

public class ProdConsumerBlockQueueDemo {
    public static void main(String[] args) {
        MyResource myResource = new MyResource(new ArrayBlockingQueue<String>(10));

        new Thread(()->{
            System.out.println(Thread.currentThread().getName() + "\t" + "生产线程启动");
            try {
                myResource.myProd();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"prod").start();


        new Thread(()->{
            System.out.println(Thread.currentThread().getName() + "\t" + "消费线程启动");
            try {
                myResource.myConsumer();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"conusmer").start();

        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "\t" + "叫停生产者");
        myResource.stop();
    }
}
