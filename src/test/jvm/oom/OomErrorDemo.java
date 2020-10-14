package test.jvm.oom;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author chenxiangge
 * @Date 2020/9/1
 */
public class OomErrorDemo {
    public static void main(String[] args) {
//        stackoverflowerror();
//        heapSpaceError();
        //98%的时间用来做GC，却只回收了2%的堆内存
//        gcOverheadLimit();
//        bufferMemoryError();
        metaspaceOOM();
        Long a = 0L;
        System.out.println(a==0);

    }

    private static void metaspaceOOM() {
        //
    }

    private static void bufferMemoryError() {
        //-Xms10M -Xmx10M -XX:+PrintGCDetails -XX:MaxDirectMemorySize=5m

        ByteBuffer.allocate(6*1024*1024);
        //直接分配os本地内存，不属于GC管辖范围，由于不需要内存拷贝所以速度相对较快
        //在直接内存中创建6M，直接撑爆直接内存（NIO编程中会出现的错误）
        ByteBuffer.allocateDirect(6*1024*1024);
        //java.lang.OutOfMemoryError: Direct buffer memory
    }


    private static void gcOverheadLimit() {
        //-Xms10M -Xmx10M -XX:+PrintGCDetails -XX:MaxDirectMemorySize=5m
        //MaxDirectMemorySize:调小直接内存大小，如果过大只能看到 OOM-heapSpace -?不是很懂对JVM还是不太熟悉
        //java.lang.OutOfMemoryError: GC overhead limit exceeded
        List<String> list = new ArrayList<>();
        int i = 0;
        try {
            while (true) {
                list.add(String.valueOf(i++));
            }
        } catch (Throwable e) {
            System.out.println("========= totalCount :" + i);
            e.printStackTrace();
        }


    }

    private static void heapSpaceError() {
        while (true) {
            //java.lang.OutOfMemoryError: Java heap space
            byte[] bytes = new byte[100 * 1024 * 1024];
        }
    }

    private static void stackoverflowerror() {
        //递归调用 抛出异常
        //java.lang.StackOverflowError
        stackoverflowerror();
    }
}
