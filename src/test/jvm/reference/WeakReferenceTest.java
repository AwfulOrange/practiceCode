package test.jvm.reference;

import test.leetcode.proxy.Obj;

import java.lang.ref.WeakReference;

/**
 * @Author chenxiangge
 * @Date 2020/8/31
 * 弱引用 无论内存是否充足，只要存在gc就会被回收
 */
public class WeakReferenceTest {
    public static void main(String[] args) {
        Object o = new Object();
        WeakReference<Object> weakReference = new WeakReference<>(o);
        System.out.println(o);
        System.out.println(weakReference.get());

        o=null;
        System.gc();

        System.out.println("========");
        System.out.println(o);
        System.out.println(weakReference.get());

    }
}
