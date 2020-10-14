package test.leetcode.java8;

import java.util.Collections;
import java.util.EnumSet;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

import static java.util.stream.Collector.Characteristics.IDENTITY_FINISH;

/**
 * @Author chenxiangge
 * @Date 2020/6/16
 */
public class MyCollectors implements Collector {
    @Override
    public Supplier supplier() {
        //声明初始化变量
        return null;
    }

    @Override
    public BiConsumer accumulator() {
        //累加操作
        return null;
    }

    @Override
    public BinaryOperator combiner() {
        //合并操作
        return null;
    }

    @Override
    public Function finisher() {
        //对最后结果进行转换（转成需要的类型）
        return null;
    }

    @Override
    public Set<Characteristics> characteristics() {
        return Collections.unmodifiableSet(EnumSet.of(IDENTITY_FINISH));
    }
}
