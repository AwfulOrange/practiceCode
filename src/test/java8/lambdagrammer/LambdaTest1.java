package test.java8.lambdagrammer;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

/**
 * @Author chenxiangge
 * @Date 2020/8/26
 * 一、Lambda表达式的基础语法：Java8中引入了一个新的操作符"->" 该操作符成为箭头操作符或Lambda操作符，箭头操作符将lambda表达式拆分成两部分
 * 左侧：参数列表
 * 右侧：执行的具体功能，即Lambda体
 * <p>
 * 语法格式1：无参数，无返回值
 * ()->System.out.println("hello");
 * <p>
 * 语法格式2：有参数，无返回值
 * (x) -> System.out.println(x);
 * <p>
 * 语法格式3：若只有一个参数（）可省略不写
 * x -> System.out.println(x);
 * <p>
 * 语法格式4；有两个以上参数，有返回值，且lambda中有多行
 * Comparator<Integer> comparator = (x,y)->{
 * System.out.println(x+":"+y);
 * return Integer.compare(x,y);
 * };
 * <p>
 * 语法格式5；有两个以上参数，有返回值，且lambda中只有单行，return & {} 都可以省略
 * Comparator<Integer> comparator1 = (x, y) -> Integer.compare(x, y);
 * <p>
 * 语法格式6；参数列表数据类型可不屑，因为JVM编译器通过上下文可以推断出数据类型 即"类型推断"
 * //不会报错 存在类型推断
 * String[] strs = {"aaa","bbb","ccc"};
 * <p>
 * //分开写，java编译器无法判断 报错
 * strs = {"aaa","bbb","ccc"};
 * <p>
 * //类型推断 ArrayList中类型不需填写
 * List<String> list = new ArrayList<>();
 *
 *
 * 上联：左右遇1括号省
 * 下联：左侧推断类型省
 * 横批：能省则省
 *
 *
 * 二、lambda表达式需要函数式接口的支持
 * 函数式接口：接口中只有一个抽象方法的接口，称为函数式接口，可以通过使用@FunctionalInterface 进行抽象方法个数的校验
 */
public class LambdaTest1 {
    public static void main(String[] args) {
        //函数式接口
        Consumer<String> consumer = (x) -> System.out.println(x);
        Consumer<String> consumer2 = x -> System.out.println(x);
        consumer.accept("a");
        consumer2.accept("n");
        Comparator<Integer> comparator = (x, y) -> {
            System.out.println(x + ":" + y);
            return Integer.compare(x, y);
        };

        Comparator<Integer> comparator1 = (x, y) -> Integer.compare(x, y);

        //不会报错 存在类型推断
        String[] strs = {"aaa", "bbb", "ccc"};

        //分开写，java编译器无法判断 报错
//        strs = {"aaa", "bbb", "ccc"};

        List<String> list = new ArrayList<>();

        //jdk 1.8 类型推断
        show(new HashMap<>());


    }

    public static void show(Map<String, String> map) {

    }
}
