package test.jvm.classload;

/**
 * @Author chenxiangge
 * @Date 1/9/21
 * <p>
 * 过程二：链接阶段
 * 基本数据类型：非final修饰的变量，在解析弧焊机进行默认初始化已赋值
 */
public class SubInitTest extends InitTest {
    static {
        id = 3;
        System.out.println("son static");
    }

    public static void main(String[] args) {
        System.out.println(id);
    }
}
