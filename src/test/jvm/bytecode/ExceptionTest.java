package test.jvm.bytecode;

/**
 * @Author chenxiangge
 * @Date 2020/12/28
 */
public class ExceptionTest {
    public static void main(String[] args) {
        System.out.println(func());
        System.out.println(func2());

    }

    //思考：如下方法的返回是多少？

    //解析：如果按照finally最终都会执行，结果应该是hi，但是实际执行发现返回的是hello

    /**
     *  0 ldc #5 <hello>
     *  2 astore_0
     *  3 aload_0
     *  4 astore_1
     *  5 ldc #6 <hi>
     *  7 astore_0
     *  8 aload_1
     *  9 areturn
     * 10 astore_2
     * 11 ldc #6 <hi>
     * 13 astore_0
     * 14 aload_2
     * 15 athrow
     *
     * @return
     */
    public static String func(){
        String str = "hello";
        try {
            return str;
        }
        finally {
            str = "hi";
        }
    }


    public static Long func2(){
        Long str = 99999L;
        try {
            return str;
        }
        finally {
            str = 10101111L;
        }
    }
}
