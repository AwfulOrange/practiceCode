package test.java8.lambdagrammer;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @Author chenxiangge
 * @Date 2020/9/27
 *
 * 一、方法引用：若lambda体中的内容有方法已经实现了，我们可以使用"方法引用"
 *              （可以理解为方法引用是lambda表达式的另外一种表现方式）
 *
 *  主要有三种语法格式：
 *  对象::实例方法名
 *  类::静态方法名
 *  类::实例方法名
 *
 * 二、构造器引用
 *     格式
 *     Class::new
 *
 * 三、数组引用
 *      Type::new
 *
 */
public class TestMethodRef {
    public static void main(String[] args) {
        //使用方法引用的前提：
        //参与类型&返回值类型需要和函数式接口的抽象方法保持一致


        //对象::实例方法名
        PrintStream ps1 = System.out;
        Consumer<String> consumer = x-> ps1.println(x);

        PrintStream ps = System.out;
        Consumer<String> con2 = ps::println;

        //类::静态方法名
        Comparator<Integer> c1 = (x,y)->Integer.compare(x,y);

        Comparator<Integer> c2 = Integer::compare;

        //类::实例方法名
        BiPredicate<String,String> biPredicate = (x,y)->x.equals(y);
        //如果lambda参数列表中，第一个参数是实例方法的调用者，第二个参数是实例方法的参数，则可以使用【类::实例方法名】这样的方法引用
        BiPredicate<String,String> biPredicate1 = String::equals;


        //Class::new
        Supplier<String> stringSupplier = () -> "";
        //运行的方法自动匹配函数式接口的抽象方法的参数-此处匹配的是无参构造器
        Supplier<String> stringSupplier1 = String::new;

        //Type::new
        Function<Integer,String[]> function = (x)->new String[x];
        function.apply(10);


        Function<Integer,String[]> function1 = String[]::new;
        function1.apply(10);





    }
}
