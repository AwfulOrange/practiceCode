package test.jvm.bytecode;

/**
 * @Author chenxiangge
 * @Date 2020/10/28
 */
public class IntegerTest {
    public static void main(String[] args) {
        Integer i = 5;
        int ii = 5;
        System.out.println(i==ii);



        Integer i1=10;
        Integer i2=10;
        System.out.println(i1==i2);


        Integer i3=128;
        Integer i4=128;
        System.out.println(i3==i4);
    }
}
