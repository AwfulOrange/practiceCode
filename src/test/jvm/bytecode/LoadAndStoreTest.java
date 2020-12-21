package test.jvm.bytecode;

import java.util.Date;

/**
 * @Author chenxiangge
 * @Date 2020/12/1
 */
public class LoadAndStoreTest {
    /**
     * 0 getstatic #2 <java/lang/System.out>
     * 3 iload_1
     * 4 invokevirtual #3 <java/io/PrintStream.println>
     * 7 getstatic #2 <java/lang/System.out>
     * 10 aload_2
     * 11 invokevirtual #4 <java/io/PrintStream.println>
     * 14 getstatic #2 <java/lang/System.out>
     * 17 lload_3
     * 18 invokevirtual #5 <java/io/PrintStream.println>
     * 21 getstatic #2 <java/lang/System.out>
     * 24 iload 5
     * 26 invokevirtual #6 <java/io/PrintStream.println>
     * 29 getstatic #2 <java/lang/System.out>
     * 32 aload 6
     * 34 invokevirtual #4 <java/io/PrintStream.println>
     * 37 return
     */
    //1、局部变量压栈指令
    public void load(int num, Object o, long count, boolean flag, short[] arr) {
        System.out.println(num);
        System.out.println(o);
        System.out.println(count);
        System.out.println(flag);
        System.out.println(arr);
    }

    //2、常量入栈指令
    public void pushConstLdc() {
        int i = -1;
        int a = 5;
        int b = 6;
        int c = 127;
        int d = 128;
        int e = 32767;
        int f = 32768;

        /**
         *  0 iconst_m1 -1
         *  1 istore_1
         *  2 iconst_5 5
         *  3 istore_2
         *  4 bipush 6
         *  6 istore_3
         *  7 bipush 127 bipush-max-127
         *  9 istore 4
         * 11 sipush 128
         * 14 istore 5
         * 16 sipush 32767 sipush-max-32767
         * 19 istore 6
         * 21 ldc #7 <32768> ldc-后面跟索引
         * 23 istore 7
         * 25 return
         */

    }

    public void constLdc() {
        long a1 = 1;
        long a2 = 2;
        float b1 = 2;
        float b2 = 3;
        double c1 = 1;
        double c2 = 2;
        Date d = null;

        /**
         *  0 lconst_1 long=1的特殊表示
         *  1 lstore_1
         *  2 ldc2_w #8 <2> long类型需要两个槽位+具体值索引
         *  5 lstore_3
         *  6 fconst_2 float类型（常量）
         *  7 fstore 5
         *  9 ldc #10 <3.0> float类型（常量）
         * 11 fstore 6
         * 13 dconst_1
         * 14 dstore 7
         * 16 ldc2_w #11 <2.0>
         * 19 dstore 9
         * 21 aconst_null null类型的特殊表示
         * 22 astore 11
         * 24 return
         */
    }


    public void store(int k,double d) {
        int m = k + 2;
        long l = 12;
        String str = "jvm-bytecode";
        float f = 10.0F;
        d = 10;
    }

    public void foo(long l,float f){
        {
            int i =0;
        }
        {
            String s = "hello world";
        }

        //局部变量表

        /**
         * 0 iconst_0
         * 1 istore 4
         * 3 ldc #19 <hello world>
         * 5 astore 4 走出方法体之后，释放槽位，第二个方法体可以复用前一个的槽位
         * 7 return
         */
    }






}
