package test.leetcode.lru;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/lru-cache/
 * 146. LRU 缓存机制
 * 手写LRU算法-hard模式
 */
class LRUCache {
    //1、创建node节点
    static class Node<K, V> {
        K key;
        V value;
        Node<K, V> prev;
        Node<K, V> next;

        //初始化node
       public Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.prev = this.next = null;
        }

        //初始化node
        public Node() {
            this.prev = this.next = null;
        }


    }

    //2、创建双向链表
    static class DoubleLinkedList<K, V> {
        Node<K, V> head;
        Node<K, V> tail;

        //2.1 初始化链表
        public DoubleLinkedList() {
            head = new Node<>();
            tail = new Node<>();

            head.next = tail;
            tail.next = head;
        }

        //2.2添加到头节点
        public void addHead(Node<K, V> node) {
            node.next = head.next;
            node.prev = head;
            head.next.prev = node;
            head.next = node;
        }

        //2.3删除节点
        public void removeNode(Node<K, V> node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            node.prev = null;
            node.next = null;
        }

        //2.4获取尾节点
        public Node<K, V> getTail() {
            return tail.prev;
        }
    }

    private int size;
    private Map<Integer, Node<Integer, Integer>> map;
    private DoubleLinkedList<Integer, Integer> linkedList;

    public LRUCache(int capacity) {
        map = new HashMap<>(capacity);
        linkedList = new DoubleLinkedList<>();
        size = capacity;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        Node<Integer, Integer> node = map.get(key);
        linkedList.removeNode(node);
        linkedList.addHead(node);
        return node.value;
    }

    public void put(Integer key, int value) {
        //已存在
        if (map.containsKey(key)) {
            Node<Integer, Integer> node = map.get(key);
            //更新value后再重新更新到map上
            node.value = value;
            map.put(key,node);
            //传入node节点删除&新增到头节点
            linkedList.removeNode(node);
            linkedList.addHead(node);
            //map中的值也需要更新
            return;
        }
        //不存在
        if (map.size() >= size) {
            //新增节点
            Node<Integer, Integer> tail = linkedList.getTail();
            linkedList.removeNode(tail);
            map.remove(tail.key);
        }
        Node<Integer, Integer> addNode = new Node<>(key, value);
        map.put(key, addNode);
        linkedList.addHead(addNode);

    }
    public static void main(String[] args) {
        LRUCache lruCacheDemo = new LRUCache(3);
        lruCacheDemo.put(1, 1);
        lruCacheDemo.put(2, 2);
        lruCacheDemo.put(3, 3);
        System.out.println(lruCacheDemo.map.keySet());
        lruCacheDemo.put(4, 1);
        System.out.println(lruCacheDemo.map.keySet());
        lruCacheDemo.put(3, 1);
        System.out.println(lruCacheDemo.map.keySet());
        lruCacheDemo.put(3, 1);
        System.out.println(lruCacheDemo.map.keySet());
        lruCacheDemo.put(3, 1);
        System.out.println(lruCacheDemo.map.keySet());
        lruCacheDemo.put(5, 1);
        System.out.println(lruCacheDemo.map.keySet());

        /**
         * true * [1, 2, 3] * [2, 3, 4] * [2, 4, 3] * [2, 4, 3] * [2, 4, 3] * [4, 3, 5] *  [1, 2, 3] [2, 3, 4] [2, 3, 4] [2, 3, 4] [2, 3, 4] [3, 4, 5]
         * [1, 2, 3] [2, 3, 4] [2, 3, 4] [2, 3, 4] [2, 3, 4] [3, 4, 5]
         *//** [1, 2, 3] [2, 3, 4] [2, 3, 4] [2, 3, 4] [2, 3, 4] [3, 4, 5] */

    }
}