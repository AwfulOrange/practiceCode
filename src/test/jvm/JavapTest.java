package test.jvm;

/**
 * @Author chenxiangge
 * @Date 2020/11/26
 */
public class JavapTest {
    private int num;
    boolean flag;
    protected char gender;
    public String info;

    public static final int COUNTS=1;
    static {
        String url = "baidu.com";
    }

    {
        info = "java";
    }

    public JavapTest() {
    }

    public JavapTest(boolean flag) {
        this.flag = flag;
    }
}
