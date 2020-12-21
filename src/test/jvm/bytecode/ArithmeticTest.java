package test.jvm.bytecode;

/**
 * @Author chenxiangge
 * @Date 2020/12/19
 */
public class ArithmeticTest {

    public static void main(String[] args) {
        method1();
        method8();
    }

    public static void method1() {
        int i = 10;
//        int j = i/0;
//        System.out.println(j);
        double jd = i / 0.0;
        System.out.println(jd); // Infinity 0.0视为一个无穷小的值 整数/无穷小= 无穷大


        double d1 = 0.0;
        double d2 = d1 / 0.0;
        System.out.println(d2);//NaN: not a number
        //不成立的等式
        /**
         * 不成立的等式
         * 以下几种情况
         * 1、d1=d2 结果应该是1
         * 2、分母是0，结果应该是0
         * 3、分子无穷小，结果应该为无穷大
         *
         * 所以最后得出结果为NaN-不是一个确定的数值
         */
    }

    public void method2() {
        float i = 10;
        float j = -i;
        i = -j;
    }

    public void method3(int j) {
        int i = 100;
//        i = i + 10;
        i += 10; //直接在局部变量表中累加，不会在操作数中新建并入栈
    }

    //关于i++ & ++i

    /**
     * 关于i++ & ++i
     * 1、结论1，不涉及其他运算，前后++没有任何区别（字节码都是一样的）
     */
    public void method6(){
//        int i =10;
//        ++i;

        int i =10;
        i++;

        /**
         * 0 bipush 10
         * 2 istore_1
         * 3 iinc 1 by 1
         * 6 return
         */
    }

    public void method7(){
        int i = 10;
        //先赋值再累加
        int a = i++;

        //先累加再赋值
        int j = 20;
        int b = ++j;
    }

    /**
     *  涉及到计算后的结果再次赋值，则可以发生
     */
    public static void method8(){
        int i =10;
        i = i++;
//        i = ++i;
        System.out.println(i);


        /**
         *  0 bipush 10
         *  2 istore_0
         *  3 iload_0
         *  4 iinc 0 by 1
         *  7 istore_0
         *  8 getstatic #4 <java/lang/System.out>
         * 11 iload_0
         * 12 invokevirtual #7 <java/io/PrintStream.println>
         * 15 return
         */



        /**
         * i = ++i;
         *  0 bipush 10
         *  2 istore_0
         *  3 iinc 0 by 1
         *  6 iload_0
         *  7 istore_0
         *  8 getstatic #4 <java/lang/System.out>
         * 11 iload_0
         * 12 invokevirtual #7 <java/io/PrintStream.println>
         * 15 return
         */


    }
}
