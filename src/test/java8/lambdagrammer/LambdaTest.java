package test.java8.lambdagrammer;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * @Author chenxiangge
 * @Date 2020/8/26
 */
public class LambdaTest {
    public static void main(String[] args) {
        //匿名内部类写法
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1,o2);
            }
        };

        TreeSet<Integer> ts = new TreeSet<>(comparator);


        //java8 lambda表达式写法
        Comparator<Integer> comparator1 = (x,y)->Integer.compare(x,y);
        TreeSet<Integer> ts1 = new TreeSet<>(comparator1);

    }
}
