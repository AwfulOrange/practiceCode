package test.leetcode.java8.delayList;

/**
 * @Author chenxiangge
 * @Date 2020/6/23
 */
public interface MyList<T> {
    T head();
    MyList<T> tail();

    default boolean isEmpty(){
        return true;
    }
}
