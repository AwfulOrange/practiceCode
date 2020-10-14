package test.leetcode.java8.delayList;

import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * 延迟列表（在最后的运算时才进行对象的创建）
 * steam的所有操作都是延迟操作
 *
 * @Author chenxiangge
 * @Date 2020/6/23
 */
public class MyLinkedList<T> implements MyList<T> {
    private final T head;
    //普通列表创建方式
//    private final MyList<T> tail;

    //    public MyLinkedList(T head, MyList<T> tail) {
//        this.head = head;
//        this.tail = tail;
//    }
    private final Supplier<MyList<T>> tail;

    public MyLinkedList(T head, Supplier<MyList<T>> tail) {
        this.head = head;
        this.tail = tail;
    }

    @Override
    public T head() {
        return head;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public MyList<T> tail() {
        MyList<T> t = tail.get();
        System.out.println(t);
        return t;
    }

    public static MyLinkedList<Integer> from(int i) {
        return new MyLinkedList(i, () -> from(i + 1));
    }

//    public MyLinkedList<Integer> filter(Predicate<T> p) {
//        return isEmpty()?
////        return new MyLinkedList(i, () -> from(i + 1));
//    }

    public static void main(String[] args) {
        MyLinkedList<Integer> numbers = from(2);
        int tow = numbers.head();
        int three = numbers.tail().head();
        int four = numbers.tail().tail().head();

        System.out.println(tow);
        System.out.println(three);
        System.out.println(four);
    }
}
