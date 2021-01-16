package test.jvm.classload;

/**
 * @Author chenxiangge
 * @Date 1/13/21
 * <p>
 * 哪些场景下不会生成<clinit>()方法？
 */
public class InitTest1 {
    //场景1 非静态变量都不会生成
    public int num = 1;

    //场景2 静态变量未显式赋值
    public static int num1;

    //场景3 静态变量显示赋值 - 会生成
//    public static int num2 = 1;

    //场景3 final静态类型 - 不会生成<clinit>()
    //在准备环节进行显式赋值
    public static final int num3 = 1;


}
