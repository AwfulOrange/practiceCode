package test.leetcode.lru;

import java.util.HashMap;
import java.util.Map;

public class ZczTest {
    public static Node head;
    public static Node tail;

    // 值库
    public static Map<String, Node> map = new HashMap<>();

    static class Node {
        private Node prev;
        private Node next;

        private String key;
        private Integer value;

        public Node(String key, Integer value) {
            this.key = key;
            this.value = value;
        }

        public Node getPrev() {
            return prev;
        }

        public void setPrev(Node prev) {
            this.prev = prev;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public Integer getValue() {
            return value;
        }

        public void setValue(Integer value) {
            this.value = value;
        }
    }

    public static void put(String key, Integer value) {
        Node node = new Node(key, value);
        if (map.size() == 0) {
            head = node;
            tail = node;
            map.put(key, node);
        } else {
            head.setPrev(node);
            node.setNext(head);
            head = node;
            map.put(key, node);
        }

        if (map.size() > 4) {
            map.remove(tail.getKey());
            tail = tail.getPrev();
        }
    }

    public static int get(String key) {
        Node node = map.get(key);
        if (node == null) {
            return -1;
        }

        Node prev = node.getPrev();
        Node next = node.getNext();

        if (prev == null && next == null) {
            return node.getValue();
        }

        if (prev == null) {
            return node.getValue();
        }

        if (next == null) {
            prev.setNext(null);
            tail = prev;
            node.setNext(head);
            head = node;
            return node.getValue();
        }

        prev.setNext(next);
        next.setPrev(prev);
        node.setPrev(null);
        node.setNext(head);
        head = node;
        return node.getValue();

    }

    public static void main(String[] args) {
        put("1", 1);
        put("2", 2);
        put("3", 3);
        put("4", 4);
        System.out.println("--------------");
        System.out.println(head.getValue());
        System.out.println(head.getNext().getValue());
        System.out.println(head.getNext().getNext().getValue());
        System.out.println(head.getNext().getNext().getNext().getValue());

        System.out.println("--------------");
        System.out.println(get("3"));

        System.out.println("--------------");
        System.out.println(head.getValue());
        System.out.println(head.getNext().getValue());
        System.out.println(head.getNext().getNext().getValue());
        System.out.println(head.getNext().getNext().getNext().getValue());

        put("5",5);

        System.out.println("--------------");
        System.out.println(head.getValue());
        System.out.println(head.getNext().getValue());
        System.out.println(head.getNext().getNext().getValue());
        System.out.println(head.getNext().getNext().getNext().getValue());
    }

}