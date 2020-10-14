package test.java8.stream;

import test.java8.vo.TestVo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * @Author chenxiangge
 * @Date 2020/10/12
 */
public class StreamTest4 {
    public static void main(String[] args) {
        TestVo testVo = new TestVo(1, 2, "tom");
        TestVo testVo2 = new TestVo(1, 3.3, "amber");
        TestVo testVo3 = new TestVo(3, 4.4, "david");

        List<TestVo> testVos = new ArrayList<>();
        testVos.add(testVo);
        testVos.add(testVo2);
        testVos.add(testVo3);

        /**
         * 取出testVo中的所有名字并按照字母顺序打印
         * 1、选取对应字段
         * 2、方法产生流
         * 3、通过flatMap合并流
         * 4、排序
         * 5、打印
         *
         */
        testVos.stream()
                .map(TestVo::getName)
                .flatMap(StreamTest4::filterChar)
                .sorted()
                .forEach(System.out::print);

        /**
         * 是否有用户叫做tom
         */
        boolean res = testVos.stream().anyMatch(o -> o.getName().equals("tom"));
        System.out.println(res);


    }

    public static Stream<Character> filterChar(String name) {
        char[] chars = name.toCharArray();
        List<Character> characters = new ArrayList<>();
        for (char aChar : chars) {
            characters.add(aChar);
        }
        return characters.stream();
    }

}
