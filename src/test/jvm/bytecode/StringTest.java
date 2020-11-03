package test.jvm.bytecode;

/**
 * @Author chenxiangge
 * @Date 2020/10/28
 */
public class StringTest {
    public static void main(String[] args) {
        String helloworld = new String("hello")+new String("World");
        String hello2  = "helloWorld";
        System.out.println(hello2.intern() == helloworld.intern());

    }
}
