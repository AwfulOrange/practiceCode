package test.java8.anno;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @Author chenxiangge
 * @Date 2020/10/24
 */
public class TestAnnosExample {

    @TestAnno("hello")
    @TestAnno("world")
    public static void test(){

    }

    public static void main(String[] args) throws NoSuchMethodException {
        Class<TestAnnosExample> clazz = TestAnnosExample.class;
        Method test = clazz.getMethod("test");
        TestAnno[] annotations = test.getAnnotationsByType(TestAnno.class);
        Arrays.stream(annotations).forEach(annotation -> System.out.println(annotation.value()));

    }
}
