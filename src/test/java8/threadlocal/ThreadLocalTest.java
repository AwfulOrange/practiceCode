package test.java8.threadlocal;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @Author chenxiangge
 * @Date 2021/1/17
 */
public class ThreadLocalTest {
    private static final ThreadLocal<Long> testLong = new ThreadLocal<>();
    private static final ThreadLocal<Long> testLongb = new ThreadLocal<>();

    public static void initThreadLocal(Long a) {
        testLong.set(a);
        System.out.println(a);
        testLongb.set(333L);

    }

    public static void main(String[] args) {
        Thread test1 = new Thread(() -> ThreadLocalTest.initThreadLocal(111L), "test1");
        Thread test2 = new Thread(() -> ThreadLocalTest.initThreadLocal(222L), "test2");
        test1.start();
        test2.start();
        try {
            TimeUnit.SECONDS.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

