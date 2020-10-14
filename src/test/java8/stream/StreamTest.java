package test.java8.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @Author chenxiangge
 * @Date 2020/9/29
 *
 * 集合讲数据，流讲究计算。
 *  1、创建 Stream
 *  2、中间操作
 *  3、终止操作（终端操作）
 *
 *
 * */
public class StreamTest {
    public static void main(String[] args) {
        //1.Collection系列集合提供的stream() or parallelSteam();
        List<String> list = new ArrayList<>();
        list.stream();

        //2.Arrays的中的方法获取数组流
        String[] strings = new String[10];
        Stream<String> stream = Arrays.stream(strings);

        //3.Stream类中的静态方法
        Stream<String> s = Stream.of("a","b","c");

        //4.创建无限流(从0开始 每次加2的流)
        Stream<Integer> iterate = Stream.iterate(0, (x) -> x + 2);
        iterate.limit(10).forEach(System.out::println);

        //5.Stream生成流
        Stream.generate(()->Math.random()).forEach(System.out::println);
    }
}
