package test.leetcode.lru;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 手写LRU算法
 * 继承LinkedHashMap
 * easy模式
 * @Author chenxiangge
 * @Date 2/18/21
 */
public class LRUCacheDemo<K, V> extends LinkedHashMap<K, V> {
    private int capacity;

    public LRUCacheDemo(int capacity) {
        /**accessOrder
         * the ordering mode -
         * <tt>true</tt> for access-order,
         * <tt>false</tt> for insertion-order
         *
         */
        super(capacity, 0.75F, false);
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        //只有当当前size大于 容量时，将最旧的一条记录删除
        return super.size() > capacity;
    }

    public static void main(String[] args) {
        LRUCacheDemo<Integer, String> demo = new LRUCacheDemo<>(3);
        demo.put(1, "a");
        demo.put(3, "C");
        demo.put(2, "b");

        //[1, 3, 2]
        System.out.println(demo.keySet());
        //访问一下1
        demo.get(1);
        demo.put(4, "d");


        //最简易的方式实现LRU
        //access-order:false： 按照插入顺序[3, 2, 4]
        //access-order:true： 按照访问顺序[2, 1, 4]
        System.out.println(demo.keySet());


    }
}
