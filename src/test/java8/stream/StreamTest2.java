package test.java8.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @Author chenxiangge
 * @Date 2020/9/29
 * <p>
 * <p>
 * 流水线的中间操作
 */
public class StreamTest2 {
    public static void main(String[] args) {
        //中间操作：不执行任何操作
        //内部迭代：streamApi完成，迭代时会根据具体场景进行*短路*操作
        //终止操作：一次性执行全部 以上操作称为*惰性求值*

        //外部迭代：自己执行的迭代操作

        /**
         * 中间操作
         */
        /**
         *
         * 筛选与切片
         * filter
         * limit：获取前N个元素的流
         * skip:获取扔掉前N个元素的流,与limit互补
         * distinct：去重，通过hashCode()和equals()方法去重复
         */

        System.out.println("-------------map---------------------");

        /**
         *
         * 映射
         * map：将旧元素映射成新元素
         * flatMap：提供一个函数作为参数，将流中的每个值都换成另一个流，然后把所有流合并成一个流
         */
        List<String> list = Arrays.asList("aaa", "bbb", "ccc");
        list.stream().map(o->o.toUpperCase()).forEach(System.out::println);




        //开始套娃 流中存流
        Stream<Stream<Character>> streamStream = list.stream().map(a -> filterCharacter(a));
        //遍历的时候也需要嵌套遍历
        streamStream.forEach(sm -> sm.forEach(System.out::println));
        //"{{a,a,a},{b,b,b},{c,c,c}}"

        System.out.println("--------------flatMap--------------------");

        //由以上情况 引出flatMap - 使用flatMap 直接返回没有嵌套的流
        Stream<Character> characterStream = list.stream().flatMap(StreamTest2::filterCharacter).sorted();
        characterStream.forEach(System.out::println);

        // **直接将流拆开拿出所有的元素后合并在一起
        // 类似于 collection.add(Object o); & collection.addAll(Collection coll)
        //"{{a,a,a},{b,b,b},{c,c,c}}" -> //"{a,a,a,b,b,b,c,c,c}"

        System.out.println("--------------add&addAllTest--------------------");

        List<String> testAdd = new ArrayList<>();
        testAdd.add("11");
        testAdd.add("22");

//        testAdd.add(list);
        testAdd.addAll(list);

        System.out.println(testAdd);


        System.out.println("--------------sort--------------------");
        /**
         * 自然排序：sorted() - Comparable.compareTo
         * 自定义排序： sorted(Comparator<? super T> comparator);
         */
    }

    public static Stream<Character> filterCharacter(String str){
        List<Character>  characters = new ArrayList<>();
        for (char c : str.toCharArray()) {
            characters.add(c);
        }
        return characters.stream();


    }
}
