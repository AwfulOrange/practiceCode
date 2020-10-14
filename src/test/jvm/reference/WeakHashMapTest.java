package test.jvm.reference;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;

/**
 * @Author chenxiangge
 * @Date 2020/9/1
 */
public class WeakHashMapTest {
    public static void main(String[] args) throws InterruptedException {
        hashMap();
        System.out.println("=================");
        weakHashMap();
    }

    private static void weakHashMap() throws InterruptedException {
        Map<String,String> hashMap = new WeakHashMap<>();
        String key = "weakHashMapKey";
//        Integer key = 1;
        String value = "weakHashMapValue";
        hashMap.put(key,value);
        System.out.println(hashMap);

        key = null;
        System.out.println(hashMap);

        //调用后不会马上执行，需要睡眠几秒才能看到效果
        //但是我好像没有看到效果？？
        System.gc();
        Thread.sleep(10000);
//        TimeUnit.SECONDS.sleep(5);
        System.out.println(hashMap);
    }

    private static void hashMap() {
        Map<String,String> hashMap = new HashMap();
        String key = "hashMapKey";
        String value = "hashMapValue";
        hashMap.put(key,value);
        System.out.println(hashMap);

        key = null;
        System.out.println(hashMap);

        System.gc();
        System.out.println(hashMap);

    }
}
