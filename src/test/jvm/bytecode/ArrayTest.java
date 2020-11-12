package test.jvm.bytecode;

/**
 * @Author chenxiangge
 * @Date 2020/11/10
 */
public class ArrayTest {
    public static void main(String[] args) {
        Object[] arr = new Object[10];
        //[Ljava.lang.Object;@61bbe9ba
        System.out.println(arr);

        String[] arrs = new String[10];
        //[Ljava.lang.String;@610455d6
        System.out.println(arrs);

        long[][] arrl = new long[10][];
        //[[J@511d50c0
        System.out.println(arrl);
    }
}
