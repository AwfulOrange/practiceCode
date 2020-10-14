package test.jvm.reference;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author chenxiangge
 * @Date 2020/8/31
 */
public class SoftReferenceTest {
    public static void main(String[] args) {
        Object o = new Object();
        SoftReference<Object> weakReference = new SoftReference<>(o);
        System.out.println(o);
        System.out.println(weakReference.get());

        o = null;

        System.gc();

        try {
            //新建大小为3M的byte数组 并控制堆内存大小 -Xms3M -Xmx3M
            //由于这样设置会造成OOM 所以要进行异常处理
            byte[] bytes = new byte[3 * 1024 * 1024];
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("========");
            System.out.println(o);
            System.out.println(weakReference.get());
        }

        Map<String,SoftReference<String>> softReferenceMap = new HashMap<>();


    }
}
