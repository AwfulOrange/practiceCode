package test.java8.stream;

import test.java8.vo.TestVo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @Author chenxiangge
 * @Date 2020/9/29
 * <p>
 * <p>
 * 流水线的终止操作
 * reduc/collect
 */
public class StreamTest3 {
    public static void main(String[] args) {
        /**
         * 查找与匹配
         * allMatch:boolean
         * anyMatch:boolean
         * noneMatch：boolean,检查是否没有匹配所有元素
         * findFirst：Optional<Object>
         * findAny:Optional<Object>
         * count：Long
         * max：Optional<Object>
         * min：Optional<Object>
         */

        /**
         * reduce:归约
         *
         */
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);

        Integer sum = list.stream().reduce(0, (x, y) -> x + y);
        System.out.println(sum);

        /**
         * map-reduce 模式
         */
        TestVo testVo = new TestVo(1, 2);
        TestVo testVo2 = new TestVo(1, 3.3);
        TestVo testVo3 = new TestVo(3, 4.4);

        List<TestVo> testVos = new ArrayList<>();
        testVos.add(testVo);
        testVos.add(testVo2);
        testVos.add(testVo3);

        /**
         * map出你想要的值之后,进行reduce操作（归约整合）
         */
        Optional<Integer> reduce = testVos.stream()
                .map(TestVo::getMaxCapacity)
                .reduce(Integer::sum);

        System.out.println(reduce.get().intValue());

        /**
         * collect(收集)
         * Collector-接口
         * Collectors-工具类：提供各种静态方法，方便创建常见收集器实例
         */
        System.out.println("=============================list");

        //变成list
        List<Integer> collect = testVos.stream().map(TestVo::getMaxCapacity).collect(Collectors.toList());
        collect.forEach(System.out::println);

        System.out.println("=============================set");

        //变成set
        Set<Integer> set = testVos.stream().map(TestVo::getMaxCapacity).collect(Collectors.toSet());
        set.forEach(System.out::println);

        //变成指定集合
        System.out.println("=============================hashset");
        HashSet<Integer> hashSet = testVos.stream().map(TestVo::getMaxCapacity).collect(Collectors.toCollection(HashSet::new));
        hashSet.forEach(System.out::println);

        //变成指定集合
        System.out.println("=============================counting");
        Long counting = testVos.stream().map(TestVo::getMaxCapacity).collect(Collectors.counting());
        Double avgInt = testVos.stream().collect(Collectors.averagingInt(TestVo::getMaxCapacity));
        Integer sumInt = testVos.stream().collect(Collectors.summingInt(TestVo::getMaxCapacity));

        System.out.println(counting);
        System.out.println(avgInt);
        System.out.println(sumInt);

        System.out.println("=============================min");
        //获取最小值-collect方式(直接在collector中选择对应的map操作)-返回的是对象
        Optional<TestVo> min = testVos.stream().collect(Collectors.minBy((a, b) -> a.getMaxCapacity() - b.getMaxCapacity()));
        System.out.println(min.get().getMaxCapacity());

        System.out.println("=============================min1");
        //获取最小值-map方式-返回的是具体的值
        Optional<Integer> min2 = testVos.stream().map(TestVo::getMaxCapacity).collect(Collectors.minBy(Integer::compareTo));
        System.out.println(min2.get());


        /**
         * 分组
         */
        Map<Integer, List<TestVo>> collect1 = testVos.stream().collect(Collectors.groupingBy(TestVo::getMaxCapacity));

        /**
         * 多级分组(可以无限分组)
         */
        Map<Integer, Map<String, List<TestVo>>> multiGroup = testVos
                .stream()
                .collect(Collectors.groupingBy(TestVo::getMaxCapacity, Collectors.groupingBy((testVo1 -> {
                    if (testVo1.getSpeed() > 3) {
                        return "高速";
                    } else {
                        return "低速";
                    }
                }))));
        System.out.println("=============================multiGroup");
        System.out.println(multiGroup);
        /**
         * 分区（分片）
         */
        Map<Boolean, List<TestVo>> collect2 = testVos.stream().collect(Collectors.partitioningBy(e -> e.getSpeed() > 3));

        System.out.println("=============================partitioning");
        System.out.println(collect2);


        /**
         * 统计数据
         */
        IntSummaryStatistics collect3 = testVos.stream().collect(Collectors.summarizingInt(TestVo::getMaxCapacity));
        collect3.getMin();
        collect3.getAverage();
        collect3.getCount();
        collect3.getMax();
        collect3.getSum();

        /**
         * 连接字符串
         */
        String joinStr = testVos.stream().map((a) -> a.getMaxCapacity().toString()).collect(Collectors.joining(","));
        System.out.println("=============================joinStr");
        System.out.println(joinStr);

    }



}
