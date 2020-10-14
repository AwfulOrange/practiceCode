package test.juc;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @Author chenxiangge
 * @Date 2020/8/13
 */
public class ContainerNotSafeDemo {
    public static void main(String[] args) {
        listNotSafe();
        setNotSafe();
        mapNotSafe();
    }

    //java.util.ConcurrentModificationException
    //并发修改异常

    /**
     * 1、故障现象
     * java.util.ConcurrentModificationException
     * 2、导致原因
     * <p>
     * <p>
     * 3、解决方案
     * 3.1 不考虑性能:使用Vector（使用synchronized加锁）
     * 3.2 寻找工具类:Collections.synchronizedList(new ArrayList<>());
     * 3.3 new CopyOnWriteArrayList<>();
     * 3.3.1 写时复制，读写分离的思想
     * 3.3.2 每次写时，拷贝原数组 并扩容+1
     * 3.3.3 适用于读多写少的情况
     * <p>
     * <p>
     * 4、优化建议
     */
    private static void listNotSafe() {
        List<String> list = new CopyOnWriteArrayList<>();


        for (int i = 1; i <= 30; i++) {
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(list);
            }, String.valueOf(i)).start();
        }
    }

    private static void setNotSafe() {
        Set<String> set = new HashSet<>();
//        Set<String> set = new CopyOnWriteArraySet<>();

        for (int i = 0; i < 30; i++) {
            new Thread(() -> {
                set.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(set.toString());
            }, String.valueOf(i)).start();
        }
    }


    private static void mapNotSafe() {
        Map<String, String> map = new HashMap<>();
//        Map<String, String> map = new ConcurrentHashMap<>();

        for (int i = 0; i < 30; i++) {
            new Thread(() -> {
                map.put(Thread.currentThread().getName(), UUID.randomUUID().toString().substring(0, 8));
                System.out.println(map);
            }, String.valueOf(i)).start();
        }
    }


    //20：20，
    //xxx
    //abc
}
