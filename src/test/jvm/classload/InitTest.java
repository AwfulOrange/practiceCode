package test.jvm.classload;

/**
 * @Author chenxiangge
 * @Date 1/9/21
 * <p>
 * 过程二：链接阶段
 * 基本数据类型：非final修饰的变量，在解析弧焊机进行默认初始化已赋值
 */
public class InitTest {
    public static long id =2;
    public static final int num = 1;
    public static final String str = "aaa";

    static {
        System.out.println("test");
    }

    public Object getObj() {

        return null;
    }
}
