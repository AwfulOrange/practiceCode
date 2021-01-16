package test.jvm.classload;

/**
 * @Author chenxiangge
 * @Date 1/13/21
 *
 * 测试类类的主动使用：调用类的<clinit>()，即执行了类的初始化阶段
 * 1、创建类的事例
 */
public class ActiveUser1 {
    public static void main(String[] args) {

    }
}
class Order{
    static {
        System.out.println("order类的初始化");
    }
}