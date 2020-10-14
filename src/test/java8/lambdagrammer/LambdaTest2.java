package test.java8.lambdagrammer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @Author chenxiangge
 * @Date 2020/8/26
 * <p>
 * Java8内置的4大核心函数式接口
 * Consumer<T>: 消费型接口
 * void accept(T t);
 * Supplier<T>: 供给型接口
 * T get();
 * <p>
 * Functioxn<T,R>: 函数型接口
 * R apply(T t)；
 * <p>
 * Predicate<T>: 断言型接口
 * boolean test(T t);
 */
public class LambdaTest2 {
    public static void main(String[] args) {

        //消费型接口
        consumer("测试消费型接口", (m) -> System.out.println("消费型接口输出中：" + m));

        //供给型接口
        List<Integer> integers = supplier(10, () -> (int) (Math.random() * 100));
        System.out.println("supplier-test");
        for (Integer integer : integers) {
            System.out.println(integer);
        }
        //函数型接口
        System.out.println(function("acb", (test) -> test.toUpperCase()));

        //断言型接口
        List<String> arrayList = filter(Arrays.asList("abc", "c", "aaa", "b"), (str) -> str.contains("a"));
        arrayList.forEach((a) -> System.out.println(a));


    }

    //筛选包含某字符的字符串
    public static List<String> filter(List<String> arrayList, Predicate<String> predicate) {
        List<String> res = new ArrayList<>();
        for (String a : arrayList) {
            if (predicate.test(a)) {
                res.add(a);
            }
        }
        return res;
    }

    //处理字符串
    public static String function(String str, Function<String, String> function) {
        return function.apply(str);
    }

    public static void consumer(String consumer, Consumer<String> con) {
        con.accept(consumer);
    }

    public static List<Integer> supplier(Integer count, Supplier<Integer> con) {
        List<Integer> integers = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            integers.add(con.get());
        }
        return integers;
    }
}
