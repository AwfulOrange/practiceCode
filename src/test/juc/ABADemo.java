package test.juc;

import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @Author chenxiangge
 * @Date 2020/8/12
 */
public class ABADemo {
    public static void main(String[] args) {
        int stamp =0;
        //带时间戳的原子引用
        AtomicStampedReference atomicStampedReference = new AtomicStampedReference(1,stamp);

    }
}

